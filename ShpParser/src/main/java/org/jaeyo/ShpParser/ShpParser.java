package org.jaeyo.ShpParser;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jaeyo.ShpParser.entity.ShapeType;
import org.jaeyo.ShpParser.entity.record.ShpRecord;
import org.jaeyo.ShpParser.entity.record.ShpRecordArc;
import org.jaeyo.ShpParser.entity.record.ShpRecordContent;
import org.jaeyo.ShpParser.entity.record.ShpRecordMultiPoint;
import org.jaeyo.ShpParser.entity.record.ShpRecordPoint;
import org.jaeyo.ShpParser.entity.record.ShpRecordPolygon;
import org.jaeyo.ShpParser.util.RandomAccessBinaryFile;

public class ShpParser implements Closeable {
	private RandomAccessBinaryFile shpRabf;

	public ShpParser(File shpFile) throws FileNotFoundException {
		this.shpRabf = new RandomAccessBinaryFile(shpFile, "r");
	} // INIT

	public ShpFileHeader parseFileHeader() throws IOException {
		shpRabf.seek(0);
		ShpFileHeader header = new ShpFileHeader();
		header.setFileCode(shpRabf.readInt(true));
		header.setUnused1(shpRabf.readInt(true));
		header.setUnused2(shpRabf.readInt(true));
		header.setUnused3(shpRabf.readInt(true));
		header.setUnused4(shpRabf.readInt(true));
		header.setUnused5(shpRabf.readInt(true));
		header.setFileLength(shpRabf.readInt(true));
		header.setVersion(shpRabf.readInt(false));
		header.setShapeType(ShapeType.getShapeType(shpRabf.readInt(false)));
		header.setBoundingBoxXmin(shpRabf.readDouble(false));
		header.setBoundingBoxYmin(shpRabf.readDouble(false));
		header.setBoundingBoxXmax(shpRabf.readDouble(false));
		header.setBoundingBoxYmax(shpRabf.readDouble(false));
		header.setBoundingBoxZmin(shpRabf.readDouble(false));
		header.setBoundingBoxZmax(shpRabf.readDouble(false));
		header.setBoundingBoxMmin(shpRabf.readDouble(false));
		header.setBoundingBoxMmax(shpRabf.readDouble(false));
		return header;
	} // parseFileHeader

	public void parseRecord(ShpRecordParseListener listener) throws IOException {
		shpRabf.seek(100);
		do {
			ShpRecord record = new ShpRecord();
			record.setRecordNumber(shpRabf.readInt(true));
			record.setContentLength(shpRabf.readInt(true));
			record.setRecordContent(parseShpRecordContent(record.getContentLength()));
			listener.onParseRecord(record);
		} while (shpRabf.getFilePointer() < shpRabf.length());
	} // parseRecord

	private ShpRecordContent parseShpRecordContent(int contentLength) throws IOException {
		ShapeType shapeType = ShapeType.getShapeType(shpRabf.readInt(false));
		switch (shapeType) {
		case NULL: {
			shpRabf.skipBytes(contentLength);
			return null;
		}
		case POINT: {
			ShpRecordPoint point = new ShpRecordPoint();
			point.setShapeType(shapeType);
			point.setX(shpRabf.readDouble(false));
			point.setY(shpRabf.readDouble(false));
			return point;
		}
		case ARC: {
			ShpRecordArc arc = new ShpRecordArc();
			arc.setShapeType(shapeType);
			double[] box = new double[4];
			for (int i = 0; i < box.length; i++)
				box[i] = shpRabf.readDouble(false);
			arc.setBox(box);
			int numParts = shpRabf.readInt(false);
			int numPoints = shpRabf.readInt(false);
			arc.setNumParts(numParts);
			arc.setNumPoints(numPoints);
			int[] parts = new int[numParts];
			for (int i = 0; i < parts.length; i++)
				parts[i] = shpRabf.readInt(false);
			arc.setParts(parts);
			ShpRecordPoint[] points = new ShpRecordPoint[numPoints];
			for (int i = 0; i < points.length; i++) {
				points[i] = new ShpRecordPoint();
				points[i].setShapeType(ShapeType.POINT);
				points[i].setX(shpRabf.readDouble(false));
				points[i].setY(shpRabf.readDouble(false));
			} // for i
			arc.setPoints(points);
			return arc;
		}
		case POLYGON: {
			ShpRecordPolygon polygon = new ShpRecordPolygon();
			polygon.setShapeType(shapeType);
			double[] box = new double[4];
			for (int i = 0; i < box.length; i++)
				box[i] = shpRabf.readDouble(false);
			polygon.setBox(box);
			int numParts = shpRabf.readInt(false);
			int numPoints = shpRabf.readInt(false);
			polygon.setNumParts(numParts);
			polygon.setNumPoints(numPoints);
			int[] parts = new int[numParts];
			for (int i = 0; i < parts.length; i++)
				parts[i] = shpRabf.readInt(false);
			polygon.setParts(parts);
			ShpRecordPoint[] points = new ShpRecordPoint[numPoints];
			for (int i = 0; i < points.length; i++) {
				points[i] = new ShpRecordPoint();
				points[i].setShapeType(ShapeType.POINT);
				points[i].setX(shpRabf.readDouble(false));
				points[i].setY(shpRabf.readDouble(false));
			} // for i
			polygon.setPoints(points);
			return polygon;
		}
		case MULTIPOINT: {
			ShpRecordMultiPoint multipoint = new ShpRecordMultiPoint();
			multipoint.setShapeType(shapeType);
			double[] box = new double[4];
			for (int i = 0; i < box.length; i++)
				box[i] = shpRabf.readDouble(false);
			multipoint.setBox(box);
			int numPoints = shpRabf.readInt(false);
			multipoint.setNumPoints(numPoints);
			ShpRecordPoint[] points = new ShpRecordPoint[numPoints];
			for (int i = 0; i < points.length; i++) {
				points[i] = new ShpRecordPoint();
				points[i].setShapeType(ShapeType.POINT);
				points[i].setX(shpRabf.readDouble(false));
				points[i].setY(shpRabf.readDouble(false));
			} // for i
			multipoint.setPoints(points);
			return multipoint;
		}
		case POINTZ:
			throw new IOException("unknown format POINTZ");
		case ARCZ:
			throw new IOException("unknown format ARCZ");
		case POLYGONZ:
			throw new IOException("unknown format POLYGONZ");
		case MULTIPOINTZ:
			throw new IOException("unknown format MULTIPOINTZ");
		case POINTM:
			throw new IOException("unknown format POINTM");
		case ARCM:
			throw new IOException("unknown format ARCM");
		case POLYGONM:
			throw new IOException("unknown format POLYGONM");
		case MULTIPOINTM:
			throw new IOException("unknown format MULTIPOINTM");
		case MULTIPATCH:
			throw new IOException("unknown format MULTIPATCH");
		default:
			throw new IOException("failed to parse");
		} // switch
	} // getShpRecordContent

	@Override
	public void close() throws IOException {
		shpRabf.close();
	} // close
} // class
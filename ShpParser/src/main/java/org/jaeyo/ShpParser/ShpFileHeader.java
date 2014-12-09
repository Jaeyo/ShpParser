package org.jaeyo.ShpParser;

import org.jaeyo.ShpParser.entity.ShapeType;

public class ShpFileHeader {
	private int fileCode;
	private int unused1;
	private int unused2;
	private int unused3;
	private int unused4;
	private int unused5;
	private int fileLength;
	private int version;
	private ShapeType shapeType;
	private double boundingBoxXmin;
	private double boundingBoxYmin;
	private double boundingBoxXmax;
	private double boundingBoxYmax;
	private double boundingBoxZmin;
	private double boundingBoxZmax;
	private double boundingBoxMmin;
	private double boundingBoxMmax;

	public int getFileCode() {
		return fileCode;
	}

	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}

	public int getUnused1() {
		return unused1;
	}

	public void setUnused1(int unused1) {
		this.unused1 = unused1;
	}

	public int getUnused2() {
		return unused2;
	}

	public void setUnused2(int unused2) {
		this.unused2 = unused2;
	}

	public int getUnused3() {
		return unused3;
	}

	public void setUnused3(int unused3) {
		this.unused3 = unused3;
	}

	public int getUnused4() {
		return unused4;
	}

	public void setUnused4(int unused4) {
		this.unused4 = unused4;
	}

	public int getUnused5() {
		return unused5;
	}

	public void setUnused5(int unused5) {
		this.unused5 = unused5;
	}

	public int getFileLength() {
		return fileLength;
	}

	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

	public double getBoundingBoxXmin() {
		return boundingBoxXmin;
	}

	public void setBoundingBoxXmin(double boundingBoxXmin) {
		this.boundingBoxXmin = boundingBoxXmin;
	}

	public double getBoundingBoxYmin() {
		return boundingBoxYmin;
	}

	public void setBoundingBoxYmin(double boundingBoxYmin) {
		this.boundingBoxYmin = boundingBoxYmin;
	}

	public double getBoundingBoxXmax() {
		return boundingBoxXmax;
	}

	public void setBoundingBoxXmax(double boundingBoxXmax) {
		this.boundingBoxXmax = boundingBoxXmax;
	}

	public double getBoundingBoxYmax() {
		return boundingBoxYmax;
	}

	public void setBoundingBoxYmax(double boundingBoxYmax) {
		this.boundingBoxYmax = boundingBoxYmax;
	}

	public double getBoundingBoxZmin() {
		return boundingBoxZmin;
	}

	public void setBoundingBoxZmin(double boundingBoxZmin) {
		this.boundingBoxZmin = boundingBoxZmin;
	}

	public double getBoundingBoxZmax() {
		return boundingBoxZmax;
	}

	public void setBoundingBoxZmax(double boundingBoxZmax) {
		this.boundingBoxZmax = boundingBoxZmax;
	}

	public double getBoundingBoxMmin() {
		return boundingBoxMmin;
	}

	public void setBoundingBoxMmin(double boundingBoxMmin) {
		this.boundingBoxMmin = boundingBoxMmin;
	}

	public double getBoundingBoxMmax() {
		return boundingBoxMmax;
	}

	public void setBoundingBoxMmax(double boundingBoxMmax) {
		this.boundingBoxMmax = boundingBoxMmax;
	}
} // class
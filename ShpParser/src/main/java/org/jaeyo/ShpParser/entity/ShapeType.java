package org.jaeyo.ShpParser.entity;

public enum ShapeType {
	NULL, POINT, ARC, POLYGON, MULTIPOINT, POINTZ, ARCZ, POLYGONZ, MULTIPOINTZ, POINTM, ARCM, POLYGONM, MULTIPOINTM, MULTIPATCH;

	public static ShapeType getShapeType(int shapeType) {
		switch (shapeType) {
		case 0:
			return ShapeType.NULL;
		case 1:
			return ShapeType.POINT;
		case 3:
			return ShapeType.ARC;
		case 5:
			return ShapeType.POLYGON;
		case 8:
			return ShapeType.MULTIPOINT;
		case 11:
			return ShapeType.POINTZ;
		case 13:
			return ShapeType.ARCZ;
		case 15:
			return ShapeType.POLYGONZ;
		case 18:
			return ShapeType.MULTIPOINTZ;
		case 21:
			return ShapeType.POINTM;
		case 23:
			return ShapeType.ARCM;
		case 25:
			return ShapeType.POLYGONM;
		case 28:
			return ShapeType.MULTIPOINTM;
		case 31:
			return ShapeType.MULTIPATCH;
		default:
			return ShapeType.NULL;
		} // switch
	} // getShapeType
}
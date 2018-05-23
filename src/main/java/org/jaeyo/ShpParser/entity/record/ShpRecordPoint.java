package org.jaeyo.ShpParser.entity.record;

import org.jaeyo.ShpParser.entity.ShapeType;

public class ShpRecordPoint implements ShpRecordContent {
	private ShapeType shapeType;
	private double x;
	private double y;

	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}

package org.jaeyo.ShpParser.entity.record;

import org.jaeyo.ShpParser.entity.ShapeType;

public class ShpRecordMultiPoint implements ShpRecordContent {
	private ShapeType shapeType;
	private double box[];
	private int numPoints;
	private ShpRecordPoint[] points;

	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

	public double[] getBox() {
		return box;
	}

	public void setBox(double[] box) {
		this.box = box;
	}

	public int getNumPoints() {
		return numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public ShpRecordPoint[] getPoints() {
		return points;
	}

	public void setPoints(ShpRecordPoint[] points) {
		this.points = points;
	}
}

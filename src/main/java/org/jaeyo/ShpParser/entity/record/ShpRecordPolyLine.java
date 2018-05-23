package org.jaeyo.ShpParser.entity.record;

import org.jaeyo.ShpParser.entity.ShapeType;

public class ShpRecordPolyLine implements ShpRecordContent{
	private ShapeType shapeType;
	private double[] box;
	private int numParts;
	private int numPoints;
	private int[] parts;
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

	public int getNumParts() {
		return numParts;
	}

	public void setNumParts(int numParts) {
		this.numParts = numParts;
	}

	public int getNumPoints() {
		return numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public int[] getParts() {
		return parts;
	}

	public void setParts(int[] parts) {
		this.parts = parts;
	}

	public ShpRecordPoint[] getPoints() {
		return points;
	}

	public void setPoints(ShpRecordPoint[] points) {
		this.points = points;
	}
}

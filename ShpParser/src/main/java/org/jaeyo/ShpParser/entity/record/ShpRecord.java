package org.jaeyo.ShpParser.entity.record;

public class ShpRecord {
	// header
	private int recordNumber;
	private int contentLength;

	// content
	private ShpRecordContent recordContent;

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public ShpRecordContent getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(ShpRecordContent recordContent) {
		this.recordContent = recordContent;
	}
} // class
package org.jaeyo.ShpParser;

import org.jaeyo.ShpParser.entity.record.ShpRecord;

public interface ShpRecordParseListener {
	public void onParseRecord(ShpRecord record);
} //interface
package org.jaeyo.ShpParser.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class RandomAccessBinaryFile extends RandomAccessFile {
	public RandomAccessBinaryFile(File file, String mode) throws FileNotFoundException {
		super(file, mode);
	} // INIT

	public RandomAccessBinaryFile(String name, String mode) throws FileNotFoundException {
		super(name, mode);
	} // INIT

	private ByteBuffer readBuffer(int length, boolean isBigEndian) throws IOException {
		byte[] bytes = new byte[length];
		read(bytes);
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		buffer.order(isBigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
		return buffer;
	} // readBuffer

	public int readInt(boolean isBigEndian) throws IOException {
		return readBuffer(4, isBigEndian).getInt();
	} // readInt

	public double readDouble(boolean isBigEndian) throws IOException {
		return readBuffer(8, isBigEndian).getDouble();
	} // readDouble
} // class
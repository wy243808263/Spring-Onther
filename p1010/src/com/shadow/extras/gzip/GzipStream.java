package com.shadow.extras.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;

/**
 * 封装GZIP STREAM对象
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class GzipStream extends ServletOutputStream {

	private GZIPOutputStream zipStream;

	public GzipStream(OutputStream out) throws IOException {
		zipStream = new GZIPOutputStream(out);
	}

	@Override
	public void flush() throws IOException {
		zipStream.flush();
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		zipStream.write(b, off, len);
	}

	@Override
	public void write(byte[] b) throws IOException {
		zipStream.write(b);
	}

	@Override
	public void write(int arg0) throws IOException {
		zipStream.write(arg0);
	}

	public void finish() throws IOException {
		zipStream.finish();
	}

	public void close() throws IOException {
		zipStream.close();
	}

}
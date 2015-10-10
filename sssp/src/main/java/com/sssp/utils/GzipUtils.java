package com.sssp.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * 
 * desc:   gzip压缩/解压
 * @author xuelin
 * @date   Oct 10, 2015
 */
public class GzipUtils {
	
	/**
	 * 
	 * desc: 解压
	 * @param theResource
	 * @return
	 * @throws IOException
	 */
	public static String decompress(byte[] theResource) throws IOException {
		GZIPInputStream is;
		is = new GZIPInputStream(new ByteArrayInputStream(theResource));
		return IOUtils.toString(is, "UTF-8");
	}
	
	/**
	 * 
	 * desc: 压缩
	 * @param theEncoded
	 * @return
	 * @throws IOException
	 */
	public static byte[] compress(String theEncoded) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		GZIPOutputStream gos = new GZIPOutputStream(os);
		IOUtils.write(theEncoded, gos, "UTF-8");
		gos.close();
		os.close();
		byte[] retVal = os.toByteArray();
		return retVal;
	}
	
}

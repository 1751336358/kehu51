package com.stx.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class UploadHeadImg {
	public static  void generateImage(String imgStr, String path) throws Exception {
		if (imgStr == null){
			throw new Exception("图片base64编码生成失败!!!");
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// 解密
			byte[] b = decoder.decodeBuffer(imgStr);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e){
			throw  new Exception("图片上传失败!!!");
		}
	}
}

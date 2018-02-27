package com.stx.utils;

import java.io.File;
import java.util.UUID;

public class FileUpload {
	public static String generateFileName(String fileName){
		//UUID_fileName
		return UUID.randomUUID().toString()+"_"+fileName;
	}
	
	public static String generateSavePath(String path,String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&15;
		int dir2 = (hashcode>>4)&15;
		String savepath = path+File.separator+dir1+File.separator+dir2;
		File file = new File(savepath);
		if(!file.exists()){
			file.mkdirs();
		}
		return savepath;
	}
}

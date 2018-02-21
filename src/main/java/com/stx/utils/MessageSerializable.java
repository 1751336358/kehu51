package com.stx.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.stx.pojo.WorkMessage;

/**
 * WorkMessage序列化与反序列化
 * @author LL
 *	2018-02-16
 */
public class MessageSerializable {
	public static byte[] serializable(WorkMessage workMessage){		
		ObjectOutputStream oos = null;    
	    ByteArrayOutputStream baos = null;    
	    try { 
	    //序列化    
	      baos = new ByteArrayOutputStream();
	      oos = new ObjectOutputStream(baos); 
	      oos.writeObject(workMessage); 
	      byte[] bytes = baos.toByteArray(); 
	      if(bytes == null){
	    	  System.out.println("序列化后为空");
	      }
	      return bytes;    
	    } catch (Exception e) {
	    	System.out.println("序列化抛异常");
	    	return null;
	    } 
	}
	
	public static  WorkMessage unSerializable(byte[]bytes){
		  ByteArrayInputStream bais = null;    
		  try {    
		  //反序列化    
		    bais = new ByteArrayInputStream(bytes);    
		    ObjectInputStream ois = new ObjectInputStream(bais);    
		    return (WorkMessage)ois.readObject();    
		  } catch (Exception e) {    
			  System.out.println("反序列化异常");
			  e.printStackTrace();
			  return null;
		  }
	}
}

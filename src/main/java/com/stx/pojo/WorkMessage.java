package com.stx.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 消息
 * @author LL
 *	2018-02-13
 */
public class WorkMessage implements Serializable{
	private static final long serialVersionUID = -1834195074615494352L;
	private String time;	//消息产生的时间
	private String type;	//消息类型，签到消息，日志消息。。。。
	private String content;	//消息内容
	/**
	 * 消息的附加属性，因为不同的消息有不同的属性，所以这里用map来存储
	 */
	private	Map<String,String> contentMap = new LinkedHashMap<String,String>();
	private int source_id;	//发送者id
	private String source_queue;	//发送者队列名
	private int distince_id;	//接收者id
	private String distince_queue;	//接受者对列名
	
	
	@Override
	public String toString() {
		return source_queue + "向" + distince_queue+"发消息" ;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Map<String, String> getContentMap() {
		return contentMap;
	}
	public void setContentMap(Map<String, String> contentMap) {
		this.contentMap = contentMap;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public String getSource_queue() {
		return source_queue;
	}
	public void setSource_queue(String source_queue) {
		this.source_queue = source_queue;
	}
	public int getDistince_id() {
		return distince_id;
	}
	public void setDistince_id(int distince_id) {
		this.distince_id = distince_id;
	}
	public String getDistince_queue() {
		return distince_queue;
	}
	public void setDistince_queue(String distince_queue) {
		this.distince_queue = distince_queue;
	}
}

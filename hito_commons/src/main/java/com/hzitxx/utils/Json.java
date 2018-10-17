package com.hzitxx.utils;

import java.util.List;
public class Json<T> {
private int code;
private String msg;
private long count;
private T data;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public Json(int code, String msg, long count, T data) {
	this.code = code;
	this.msg = msg;
	this.count = count;
	this.data = data;
}
public Json() {
	
}
}

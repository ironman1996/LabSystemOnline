package com.shine.entity;

public class Result<T> {
	
	private int status;
	private String message;
	private T  data;//���������ͨ�����Ϳ��Է��κ����͵�����
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
}

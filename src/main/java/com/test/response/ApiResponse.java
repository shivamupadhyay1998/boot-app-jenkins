package com.test.response;

public class ApiResponse<T> {

	private  String massage;
	private T data;
	private int status;
	public ApiResponse(String massage, T data, int status) {
		super();
		this.massage = massage;
		this.data = data;
		this.status = status;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

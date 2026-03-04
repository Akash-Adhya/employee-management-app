package com.ems.dto;

import java.time.LocalDateTime;

public class ApiResponseDTO<T>{
	private int status;
	private String message;
	private LocalDateTime timestamp;
	private T data;
	public ApiResponseDTO() {
		super();
	}
	public ApiResponseDTO(int status, String message, LocalDateTime timestamp, T data) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
		this.data = data;
	}
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
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ApiResponseDTO [status=" + status + ", message=" + message + ", timestamp=" + timestamp + ", data="
				+ data + "]";
	}
}

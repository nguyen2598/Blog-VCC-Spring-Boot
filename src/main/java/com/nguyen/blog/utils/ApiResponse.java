package com.nguyen.blog.utils;

public  class ApiResponse<T> {
    private boolean success;
    private T data;
    private int status;
    private String message;

    public ApiResponse(boolean success, T data, int status, String message) {
        this.success = success;
        this.data = data;
        this.status = status;
        this.message = message;
    }

    // Getters and setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
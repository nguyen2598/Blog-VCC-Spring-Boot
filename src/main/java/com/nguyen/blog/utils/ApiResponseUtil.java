package com.nguyen.blog.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {

    public static <T> ResponseEntity<Object> ok(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(true, data, HttpStatus.OK.value(), "ok")
        );
    }

    public static ResponseEntity<Object> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ApiResponse<>(false, null, HttpStatus.NOT_FOUND.value(), message != null ? message : "Cannot find resources")
        );
    }

    public static ResponseEntity<ApiResponse<String>> error(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ApiResponse<String>(false, null, HttpStatus.INTERNAL_SERVER_ERROR.value(), message != null ? message : "Internal server error")
        );
    }

    public static ResponseEntity<Object> unauthorized(String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new ApiResponse<>(false, null, HttpStatus.UNAUTHORIZED.value(), message != null ? message : "Unauthorized")
        );
    }

    public static ResponseEntity<Object> invalidated(Object errors) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new ApiResponse<>(false, errors, HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validation errors")
        );
    }

//    public static class ApiResponse<T> {
//        private boolean success;
//        private T data;
//        private int status;
//        private String message;
//
//        public ApiResponse(boolean success, T data, int status, String message) {
//            this.success = success;
//            this.data = data;
//            this.status = status;
//            this.message = message;
//        }
//
//        // Getters and setters
//
//        public boolean isSuccess() {
//            return success;
//        }
//
//        public void setSuccess(boolean success) {
//            this.success = success;
//        }
//
//        public T getData() {
//            return data;
//        }
//
//        public void setData(T data) {
//            this.data = data;
//        }
//
//        public int getStatus() {
//            return status;
//        }
//
//        public void setStatus(int status) {
//            this.status = status;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//    }
}

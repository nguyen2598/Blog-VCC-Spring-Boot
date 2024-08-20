package com.nguyen.blog.Exception;


import com.nguyen.blog.utils.ApiResponse;
import com.nguyen.blog.utils.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
//    ResponseEntity<String> handlingRuntimeException(RuntimeException exception) {
//        return  ResponseEntity.badRequest().body(exception.getMessage());
//    }
    ResponseEntity<ApiResponse<String>> handlingRuntimeException(RuntimeException exception) {
        return ApiResponseUtil.error("Runtime");
//        return  ResponseEntity.badRequest().body(exception.getMessage());
    }
}

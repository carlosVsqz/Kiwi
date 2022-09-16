package com.esc.micro.kiwi.appication.utils;

import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CreateExceptionSignature<T> {

  public T createException(Boolean status, HttpStatus httpStatus, String message) {
    return (T) new ApiResponse(status, message, httpStatus);
  }
}

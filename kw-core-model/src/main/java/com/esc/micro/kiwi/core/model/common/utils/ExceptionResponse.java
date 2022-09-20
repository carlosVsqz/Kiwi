package com.esc.micro.kiwi.core.model.common.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ExceptionResponse {

  private static final long serialVersionUID = 7702134516418120340L;

  private Boolean success;

  private String message;

  private HttpStatus status;

  public ExceptionResponse() {
  }

  public ExceptionResponse(Boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public ExceptionResponse(Boolean success, String message, HttpStatus httpStatus) {
    this.success = success;
    this.message = message;
    this.status = httpStatus;
  }
}

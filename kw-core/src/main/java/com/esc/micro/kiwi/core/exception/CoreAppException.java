package com.esc.micro.kiwi.core.exception;

public class CoreAppException extends RuntimeException{

  private static final long serialVersionUID = 1L;

  public CoreAppException(String message) {
    super(message);
  }

  public CoreAppException(String message, Throwable cause) {
    super(message, cause);
  }
}

package com.esc.micro.kiwi.app.model.exception;

public class PostException extends Exception{

  public PostException() {
  }

  public PostException(String message) {
    super(message);
  }

  public PostException(String message, Throwable cause) {
    super(message, cause);
  }

  public PostException(Throwable cause) {
    super(cause);
  }

  public PostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}

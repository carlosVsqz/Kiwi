package com.esc.micro.kiwi.core.model.common.utils;

public class ResourceNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private final String resourceName;
  private final String fieldName;
  private final Object fieldValue;
  private transient ExceptionResponse apiResponse;

  public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
    super();
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }

  public ExceptionResponse getApiResponse() {
    return apiResponse;
  }

  private void setApiResponse() {
    String message = String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue);

    apiResponse = new ExceptionResponse(Boolean.FALSE, message);
  }
}

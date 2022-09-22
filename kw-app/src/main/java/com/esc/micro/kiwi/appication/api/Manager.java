package com.esc.micro.kiwi.appication.api;

import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public abstract class Manager {

  protected ResponseEntity createResponseApi(final ApiResponse apiResponse) {
    return new ResponseEntity(apiResponse, new HttpHeaders(), apiResponse.getStatus());
  }
}

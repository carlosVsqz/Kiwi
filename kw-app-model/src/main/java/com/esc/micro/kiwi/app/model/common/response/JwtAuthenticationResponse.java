package com.esc.micro.kiwi.app.model.common.response;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {
  private String accessToken;

  public JwtAuthenticationResponse(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}

package com.esc.micro.kiwi.app.model.common.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"usernameOrEmail", "password"})
public class LoginRequest {

  public LoginRequest() {
  }

  private String usernameOrEmail;
  private String password;

  public String getUsernameOrEmail() {
    return usernameOrEmail;
  }

  public void setUsernameOrEmail(String usernameOrEmail) {
    this.usernameOrEmail = usernameOrEmail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

package com.esc.micro.kiwi.app.model.common.user;

import com.esc.micro.kiwi.app.model.common.user.role.RoleData;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class UserData implements Serializable {

  public UserData() {
  }

  @JsonIgnore
  private static final long serialVersionUID = 1L;

  private String email;
  private String firstName;
  private String lastName;
  private String password;
  private String phone;
  private String username;
  private String webSite;

  private List<RoleData> roles;

  public List<RoleData> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleData> roles) {
    this.roles = roles;
  }

  public UserData(String firstName, String lastName, String username, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }
}

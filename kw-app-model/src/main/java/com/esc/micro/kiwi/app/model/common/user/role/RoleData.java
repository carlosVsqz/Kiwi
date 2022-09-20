package com.esc.micro.kiwi.app.model.common.user.role;

import java.io.Serializable;

public class RoleData implements Serializable {

  private String name;

  public RoleData() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package com.esc.micro.kiwi.app.model.common.response.post;

import java.io.Serializable;

public class TagData implements Serializable {

  public TagData() {
  }

  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

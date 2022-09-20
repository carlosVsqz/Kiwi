package com.esc.micro.kiwi.app.model.common.Project;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ProjectData implements Serializable {

  @JsonIgnore
  private static final long serialVersionUID = 1L;
  private String type;
  private Boolean status;
  public ProjectData() {
  }

}

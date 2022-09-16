package com.esc.micro.kiwi.app.model.common.response;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
class ItemWithIdentity {
  protected long id;
  protected long projectCount;
  protected long projectPerDay;
  protected long userCount;
  protected long userPerDay;
  //    protected List<Tag> tags;
  @JsonIgnore
  protected SiteStatResponse owner;
//    protected List<Project> projects;

  public ItemWithIdentity(long projectCount,
                          long projectPerDay,
                          long userCount,
                          long userPerDay,
//                            List<Tag> tags,
//                          List<Project> projects,
                          SiteStatResponse owner
  ) {
    this.projectCount = projectCount;
    this.projectPerDay = projectPerDay;
    this.userCount = userCount;
    this.userPerDay = userPerDay;
//    this.tags = tags;
    this.owner = owner;
//    this.projects = projects;
  }
}

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "response")
@JsonPropertyOrder({"status", "result", "response"})
@Getter
public class SiteStatResponse {
  protected String status;

  protected List<ItemWithIdentity> result;
  protected HttpStatus response;

  public SiteStatResponse(String status, HttpStatus response) {
    this.status = status;
    this.response = response;
    this.result = new ArrayList<>();
  }

  public void addItem(long pCount,
                      long pPerDay,
                      long uCount,
                      long uPerDay
//                      List<Tag> tags,
//                      List<Project> projects
  ) {

    this.result.add(new ItemWithIdentity(pCount, pPerDay, uCount,
        uPerDay,
//        tags,
        this
//        projects
    ));
  }

}

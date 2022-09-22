package com.esc.micro.kiwi.app.model.common.response.post;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.app.model.common.user.UserData;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PostData implements Serializable {

  public PostData() {
  }

  private String id;
  private String image;
  private List<TagData> tags;
  private UserData user;
  private String type;
  private String title;
  private Date publicDate;
  private Boolean isTrending;
  private List<CategoryData> category;
  private String description;
  private List<String> comments;
  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<TagData> getTags() {
    return tags;
  }

  public void setTags(List<TagData> tags) {
    this.tags = tags;
  }

  public UserData getUser() {
    return user;
  }

  public void setUser(UserData user) {
    this.user = user;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getPublicDate() {
    return publicDate;
  }

  public void setPublicDate(Date publicDate) {
    this.publicDate = publicDate;
  }

  public Boolean getTrending() {
    return isTrending;
  }

  public void setTrending(Boolean trending) {
    isTrending = trending;
  }

  public List<CategoryData> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryData> category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getComments() {
    return comments;
  }

  public void setComments(List<String> comments) {
    this.comments = comments;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}

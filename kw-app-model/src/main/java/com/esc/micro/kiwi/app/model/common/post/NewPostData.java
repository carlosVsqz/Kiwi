package com.esc.micro.kiwi.app.model.common.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewPostData implements Serializable {

  private String name;
  private String image;
  private String type;
  private String title;
  private String content;
  private String description;
  private String URlStorage;

  private List<Tag> tags;
  private List<Category> categories;

  public NewPostData() {
  }

  public List<Long> getTagsListId() {
    List<Long> ids = new ArrayList<>();

    if (Objects.nonNull(this.getTags())) {
      for (Tag tag : this.getTags()) {
        ids.add(Long.valueOf(tag.getId()));
      }
    }

    return ids;
  }

  public List<Long> getCategoryListId() {
    List<Long> ids = new ArrayList<>();

    if (Objects.nonNull(this.getCategories())) {
      for (Category category : this.getCategories()) {
        ids.add(Long.valueOf(category.getId()));
      }
    }

    return ids;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getURlStorage() {
    return URlStorage;
  }

  public void setURlStorage(String URlStorage) {
    this.URlStorage = URlStorage;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}

class Tag {
  private String id;
  private String name;

  public Tag() {
  }

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

class Category {
  private String id;
  private String key;

  public Category() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
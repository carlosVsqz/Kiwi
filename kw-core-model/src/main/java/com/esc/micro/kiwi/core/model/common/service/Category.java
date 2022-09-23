package com.esc.micro.kiwi.core.model.common.service;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Category.
 */

@Entity
@Table(name = "category")
public class Category extends ManagerEntity<Long, Category> {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;

  @Column(name = "key")
  private String key;

  @Column(name = "image")
  private String image;

  public Category() {
  }

  /**
   * Instantiates a new Category.
   *
   * @param name the name
   */
  public Category(String name) {
    super();
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Category category = (Category) o;

    return Objects.equals(id, category.id);
  }

  @Override
  public int hashCode() {
    return 1596826009;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}

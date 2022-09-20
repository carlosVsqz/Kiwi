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
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  private List<Post> posts;

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

  /**
   * Gets posts.
   *
   * @return the posts
   */
  public List<Post> getPosts() {
    return posts == null ? null : new ArrayList<>(posts);
  }

  /**
   * Sets posts.
   *
   * @param posts the posts
   */
  public void setPosts(List<Post> posts) {
    if (posts == null)
      this.posts = null;
    else
      this.posts = Collections.unmodifiableList(posts);
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
}

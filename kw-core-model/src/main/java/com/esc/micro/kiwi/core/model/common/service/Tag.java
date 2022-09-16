package com.esc.micro.kiwi.core.model.common.service;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Tag.
 */
@Entity
@Table(name = "tags")
public class Tag extends ManagerEntity<Long, Tag> {

  private static final long serialVersionUID = 1L;

  public Tag() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
  private List<Post> posts;

  /**
   * Instantiates a new Tag.
   *
   * @param name the name
   */
  public Tag(String name) {
    super();
    this.name = name;
  }

  /**
   * Gets posts.
   *
   * @return the posts
   */
  public List<Post> getPosts() {
    return this.posts == null ? null : new ArrayList<>(this.posts);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Tag tag = (Tag) o;

    return Objects.equals(id, tag.id);
  }

  @Override
  public int hashCode() {
    return 50257180;
  }
}

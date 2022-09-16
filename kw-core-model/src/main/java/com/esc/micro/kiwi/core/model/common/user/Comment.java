package com.esc.micro.kiwi.core.model.common.user;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.service.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Comment.
 */
@Entity
@Table(name = "comments")
public class Comment extends ManagerEntity<Long, Comment> {
  private static final long serialVersionUID = 1L;

  public Comment() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "body")
  private String body;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Post post;

  /**
   * Instantiates a new Comment.
   *
   * @param body the body
   */
  public Comment(String body) {
    this.body = body;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return this.user;
  }

  /**
   * Gets post.
   *
   * @return the post
   */
  public Post getPost() {
    return this.post;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Comment comment = (Comment) o;

    return Objects.equals(id, comment.id);
  }

  @Override
  public int hashCode() {
    return 860659860;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setPost(Post post) {
    this.post = post;
  }
}

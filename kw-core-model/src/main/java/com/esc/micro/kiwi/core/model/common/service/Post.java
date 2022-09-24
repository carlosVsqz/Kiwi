package com.esc.micro.kiwi.core.model.common.service;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.project.Project;
import com.esc.micro.kiwi.core.model.common.user.Comment;
import com.esc.micro.kiwi.core.model.common.user.User;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

/**
 * The type Post.
 */
@Entity
@Table(name = "posts")
public class Post extends ManagerEntity<Long, Post> {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;

  @Column(name = "image")
  private String image;

  @Column(name = "type")
  private String type;

  @Column(name = "title")
  private String title;

  private boolean isTrending;

  private boolean status;

  private Date publicDate;

  @Column(name = "content")
  private String content;

  @Column(name = "url_storage")
  private String URLStorage;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "post_tag",
      joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
  private Set<Tag> tags;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "post_project",
      joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
  private Set<Project> projects;
  @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
  private List<Comment> comments;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "post_category",
      joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
  private Set<Category> categories;

  public Post() {
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user the user
   */
  public void setUser(User user) {
    this.user = user;
  }


  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    if (tags == null)
      this.tags = null;
    else
      this.tags = Collections.unmodifiableSet(tags);
  }

  public void setProjects(Set<Project> projects) {
    this.projects = projects;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Post post = (Post) o;

    return Objects.equals(id, post.id);
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return 949848249;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getURLStorage() {
    return URLStorage;
  }

  public void setURLStorage(String URLStorage) {
    this.URLStorage = URLStorage;
  }

  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }

  public Set<Project> getProjects() {
    return projects;
  }

  public List<Comment> getComments() {
    return comments;
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

  public boolean isTrending() {
    return isTrending;
  }

  public void setTrending(boolean trending) {
    isTrending = trending;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Date getPublicDate() {
    return publicDate;
  }

  public void setPublicDate(Date publicDate) {
    this.publicDate = publicDate;
  }

  @Override
  public String toString() {
    return "Post{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", Description='" + description + '\'' +
        ", URLStorage='" + URLStorage + '\'' +
        ", user=" + user +
        ", category=" + categories +
        ", tags=" + tags +
        '}';
  }
}

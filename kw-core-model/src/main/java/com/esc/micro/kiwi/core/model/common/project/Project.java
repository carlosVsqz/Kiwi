package com.esc.micro.kiwi.core.model.common.project;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.payment.Payment;
import com.esc.micro.kiwi.core.model.common.payment.Rate;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.model.common.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Project.
 */
@Entity
@Table(name = "projects")
public class Project extends ManagerEntity<Long, Project> {
  private static final long serialVersionUID = 1L;

  public Project() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;

  private Boolean status;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Payment> payments;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "post_project",
      joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
  private List<Post> posts;

  @OneToMany(mappedBy = "project", fetch = FetchType.EAGER,
      cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Rate> rates;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Score> scores;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "scope_project",
      joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "scope_id", referencedColumnName = "id"))
  private List<Scope> scopes;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Project project = (Project) o;

    return Objects.equals(id, project.id);
  }

  @Override
  public int hashCode() {
    return 1545761250;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Rate> getRates() {
    return rates;
  }

  public void setRates(List<Rate> rates) {
    this.rates = rates;
  }

  public List<Score> getScores() {
    return scores;
  }

  public void setScores(List<Score> scores) {
    this.scores = scores;
  }

  public List<Scope> getScopes() {
    return scopes;
  }

  public void setScopes(List<Scope> scopes) {
    this.scopes = scopes;
  }
}

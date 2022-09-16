package com.esc.micro.kiwi.core.model.common.project;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.model.common.user.init.Postulation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Skill.
 */
@Entity
@Table(name = "skills")
public class Skill extends ManagerEntity<Long, Skill> {
  private static final long serialVersionUID = 1L;

  public Skill() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "postulation_id")
  private Postulation postulation;

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Skill skill = (Skill) o;

    return Objects.equals(id, skill.id);
  }

  @Override
  public int hashCode() {
    return 1942764761;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Postulation getPostulation() {
    return postulation;
  }

  public void setPostulation(Postulation postulation) {
    this.postulation = postulation;
  }
}

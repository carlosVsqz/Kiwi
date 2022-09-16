package com.esc.micro.kiwi.core.model.common.user.init;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.project.Skill;
import com.esc.micro.kiwi.core.model.common.user.User;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Postulation.
 */
@Entity
@Table(name = "postulations")
public class Postulation extends ManagerEntity<Long, Postulation> {
  private static final long serialVersionUID = 1L;

  public Postulation() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "postulation", cascade = CascadeType.ALL, orphanRemoval = true)

  private List<Skill> skills;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "postulation_geo",
      joinColumns = @JoinColumn(name = "postulation_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "geo_id", referencedColumnName = "id"))
  private List<Geo> geos;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Postulation that = (Postulation) o;

    return Objects.equals(id, that.id);
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
    return 1636120107;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Geo> getGeos() {
    return geos;
  }

  public void setGeos(List<Geo> geos) {
    this.geos = geos;
  }
}

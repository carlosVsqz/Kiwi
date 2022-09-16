package com.esc.micro.kiwi.core.model.common.project;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Scope.
 */
@Entity
@Table(name = "scopes")
public class Scope extends ManagerEntity<Long, Scope> {
  private static final long serialVersionUID = 1L;

  public Scope() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "scope_project",
      joinColumns = @JoinColumn(name = "scope_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
  private List<Project> projects;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Scope scope = (Scope) o;

    return Objects.equals(id, scope.id);
  }

  @Override
  public int hashCode() {
    return 1768383567;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }
}

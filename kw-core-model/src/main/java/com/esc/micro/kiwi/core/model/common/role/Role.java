package com.esc.micro.kiwi.core.model.common.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Role.
 */
@Entity
@Table(name = "roles")
public class Role {

  public Role() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @NaturalId
  @Column(name = "name")
  private RoleName name;

  /**
   * Instantiates a new Role.
   *
   * @param name the name
   */
  public Role(RoleName name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Role role = (Role) o;

    return Objects.equals(name, role.name);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RoleName getName() {
    return name;
  }

  public void setName(RoleName name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

}

package com.esc.micro.kiwi.core.model.common.payment;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.project.Project;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.model.common.user.init.Company;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Rate.
 */
@Entity
@Table(name = "rates")
public class Rate extends ManagerEntity<Long, Rate> {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id")
  private Project project;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  private Company company;

  public Rate() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Rate rate = (Rate) o;

    return Objects.equals(id, rate.id);
  }

  @Override
  public int hashCode() {
    return 1101571590;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }
}

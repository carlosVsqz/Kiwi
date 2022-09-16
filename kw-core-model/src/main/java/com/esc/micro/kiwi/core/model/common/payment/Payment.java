package com.esc.micro.kiwi.core.model.common.payment;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.project.Project;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Payment.
 */
@Entity
@Table(name = "payments")
public class Payment extends ManagerEntity<Long, Payment> {
  private static final long serialVersionUID = 1L;

  public Payment() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "format")
  private String format;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id")
  private Project project;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Payment payment = (Payment) o;

    return Objects.equals(id, payment.id);
  }

  @Override
  public int hashCode() {
    return 1545849159;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}

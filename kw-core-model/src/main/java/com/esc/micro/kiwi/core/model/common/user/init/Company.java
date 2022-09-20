package com.esc.micro.kiwi.core.model.common.user.init;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.payment.Rate;
import com.esc.micro.kiwi.core.model.common.project.Score;
import com.esc.micro.kiwi.core.model.common.user.User;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Company.
 */
@Entity
@Table(name = "company")
public class Company extends ManagerEntity<Long, Company> {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "catch_phrase")
  private String catchPhrase;
  @Column(name = "bs")
  private String bs;
  @OneToOne(mappedBy = "company")
  private User user;
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Rate> rates;
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Score> scores;
  public Company() {
  }

  /**
   * Instantiates a new Company.
   *
   * @param name        the name
   * @param catchPhrase the catch phrase
   * @param bs          the bs
   */
  public Company(String name, String catchPhrase, String bs) {
    this.name = name;
    this.catchPhrase = catchPhrase;
    this.bs = bs;
  }

  @Override
  public Long getId() {
    return id;
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

  public String getCatchPhrase() {
    return catchPhrase;
  }

  public void setCatchPhrase(String catchPhrase) {
    this.catchPhrase = catchPhrase;
  }

  public String getBs() {
    return bs;
  }

  public void setBs(String bs) {
    this.bs = bs;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Company company = (Company) o;

    return Objects.equals(id, company.id);
  }

  @Override
  public int hashCode() {
    return 56842787;
  }
}

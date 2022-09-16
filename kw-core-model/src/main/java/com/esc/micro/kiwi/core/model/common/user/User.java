package com.esc.micro.kiwi.core.model.common.user;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.manager.audit.AuditSection;
import com.esc.micro.kiwi.core.model.common.manager.audit.Auditable;
import com.esc.micro.kiwi.core.model.common.manager.listener.AuditListener;
import com.esc.micro.kiwi.core.model.common.payment.Rate;
import com.esc.micro.kiwi.core.model.common.project.Project;
import com.esc.micro.kiwi.core.model.common.project.Skill;
import com.esc.micro.kiwi.core.model.common.role.Role;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.model.common.user.init.Address;
import com.esc.micro.kiwi.core.model.common.user.init.Company;
import com.esc.micro.kiwi.core.model.common.user.init.Postulation;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type User.
 */
@EntityListeners(value = AuditListener.class)
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User extends ManagerEntity<Long, User> implements Auditable {

  private static final long serialVersionUID = 1L;

  public User() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  private String password;

  private String phone;

  private String username;

  private String webSite;

  private Boolean status;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private List<Role> roles;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "company_id")
  private Company company;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comment> comments;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Project> projects;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Postulation> postulations;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Rate> rates;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Skill> skills;
  @Embedded
  private AuditSection auditSection = new AuditSection();

  public User(String firstName, String lastName, String username, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public List<Role> getRoles() {

    return roles == null ? null : new ArrayList<>(roles);
  }

  public void setRoles(List<Role> roles) {

    if (roles == null) {
      this.roles = null;
    } else {
      this.roles = Collections.unmodifiableList(roles);
    }
  }

  public List<Comment> getComments() {
    return this.comments == null ? null : new ArrayList<>(this.comments);
  }

  public void setComments(List<Comment> comments) {
    if (comments == null)
      this.comments = null;
    else
      this.comments = Collections.unmodifiableList(comments);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  public List<Postulation> getPostulations() {
    return postulations;
  }

  public void setPostulations(List<Postulation> postulations) {
    this.postulations = postulations;
  }

  public List<Rate> getRates() {
    return rates;
  }

  public void setRates(List<Rate> rates) {
    this.rates = rates;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Override
  public AuditSection getAuditSection() {
    return auditSection;
  }

  @Override
  public void setAuditSection(AuditSection audit) {
    this.auditSection = audit;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

}

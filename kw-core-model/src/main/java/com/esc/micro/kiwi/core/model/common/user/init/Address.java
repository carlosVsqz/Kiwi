package com.esc.micro.kiwi.core.model.common.user.init;

import com.esc.micro.kiwi.core.model.common.manager.ManagerEntity;
import com.esc.micro.kiwi.core.model.common.user.User;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Address.
 */
@Entity
@Table(name = "address")
public class Address extends ManagerEntity<Long, Address> {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "street")
  private String street;
  @Column(name = "suite")
  private String suite;
  @Column(name = "city")
  private String city;
  @Column(name = "zipcode")
  private String zipcode;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "geo_id")
  private Geo geo;
  @OneToOne(mappedBy = "address")
  private User user;

  public Address() {
  }

  /**
   * Instantiates a new Address.
   *
   * @param street  the street
   * @param suite   the suite
   * @param city    the city
   * @param zipcode the zipcode
   * @param geo     the geo
   */
  public Address(String street, String suite, String city, String zipcode, Geo geo) {
    this.street = street;
    this.suite = suite;
    this.city = city;
    this.zipcode = zipcode;
    this.geo = geo;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Address address = (Address) o;

    return Objects.equals(id, address.id);
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getSuite() {
    return suite;
  }

  public void setSuite(String suite) {
    this.suite = suite;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public Geo getGeo() {
    return geo;
  }

  public void setGeo(Geo geo) {
    this.geo = geo;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    return 1395783287;
  }
}

package com.esc.micro.kiwi.core.model.common.user.init;


import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Geo.
 */
@Entity
@Table(name = "geo")
public class Geo {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "lat")
  private String lat;
  @Column(name = "lng")
  private String lng;
  @OneToOne(mappedBy = "geo")
  private Address address;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "postulation_geo",
      joinColumns = @JoinColumn(name = "postulation_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "geo_id", referencedColumnName = "id"))
  private List<Postulation> postulations;
  public Geo() {
  }

  /**
   * Instantiates a new Geo.
   *
   * @param lat the lat
   * @param lng the lng
   */
  public Geo(String lat, String lng) {
    this.lat = lat;
    this.lng = lng;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Postulation> getPostulations() {
    return postulations;
  }

  public void setPostulations(List<Postulation> postulations) {
    this.postulations = postulations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Geo geo = (Geo) o;

    return Objects.equals(id, geo.id);
  }

  @Override
  public int hashCode() {
    return 633472264;
  }
}

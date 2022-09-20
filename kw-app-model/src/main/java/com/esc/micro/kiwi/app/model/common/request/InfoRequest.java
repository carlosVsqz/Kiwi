package com.esc.micro.kiwi.app.model.common.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class InfoRequest implements Serializable {

  @JsonIgnore
  private static final long serialVersionUID = 1L;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String companyName;
  private String catchPhrase;
  private String bs;
  private String website;
  private String phone;
  private String lat;
  private String lng;

  public InfoRequest() {
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

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
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

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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
}

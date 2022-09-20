package com.esc.micro.kiwi.app.model.common.user;

import java.io.Serializable;
import java.time.Instant;

public class UserProfile implements Serializable {

  private Long id;
  private String username;
  private String firstName;
  private String lastName;
  private Instant joinedAt;
  private String email;
  //  private AddressData address;
  private String phone;
  private String website;
  public UserProfile() {
  }
//  private CompanyData company;
}

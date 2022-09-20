package com.esc.micro.kiwi.appication.security.impl;

import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.appication.security.CustomUserDetailsService;
import com.esc.micro.kiwi.appication.security.model.UserPrincipal;
import com.esc.micro.kiwi.core.services.user.DetailsUserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {

  @Resource
  private DetailsUserService detailsUserService;

  @Resource
  private ModelMapper mapper;

  @Override
  public UserDetails loadUserByUsername(String usernameOrEmail) {
    final Optional<UserPrincipalDetails> userPrincipalDetails = detailsUserService.getCurrentUserDetail(usernameOrEmail);

    if (userPrincipalDetails.isPresent()) {
      return UserPrincipal.create(userPrincipalDetails.get());
    } else {
      throw new UsernameNotFoundException(String.format("User not found with this username or email: %s", usernameOrEmail));
    }
  }

  @Override
  public UserDetails loadUserById(Long id) {

    UserData userData = detailsUserService.getUserById(id);

    UserPrincipalDetails userPrincipalDetails = mapper.map(userData, UserPrincipalDetails.class);

    userPrincipalDetails.setRoleDataSet(userData.getRoles());

    return UserPrincipal.create(userPrincipalDetails);
  }
}

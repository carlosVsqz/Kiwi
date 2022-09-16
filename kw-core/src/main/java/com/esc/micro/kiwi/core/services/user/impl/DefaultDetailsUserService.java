package com.esc.micro.kiwi.core.services.user.impl;

import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.repositories.user.UserRepository;
import com.esc.micro.kiwi.core.services.user.DetailsUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DefaultDetailsUserService implements DetailsUserService {

  @Resource
  private UserRepository userRepository;

  @Resource
  private MapperConverter<User, UserData> userDataMapperConverter;

  @Resource
  private MapperConverter<User, UserPrincipalDetails> detailsUserServiceConverter;

  @Override
  public Optional<UserPrincipalDetails> getCurrentUserDetail(String usernameOrEmail) {

    Optional<User> currentUser = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    if (currentUser.isPresent())
      return Optional.ofNullable(detailsUserServiceConverter.convert(currentUser.get()));

    return Optional.empty();
  }

  @Override
  public UserData getUserById(Long id) {
    Optional<User> user = userRepository.findById(id);

    if (user.isPresent())
      return userDataMapperConverter.convert(user.get());

    return null;
  }
}

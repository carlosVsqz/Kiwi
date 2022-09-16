package com.esc.micro.kiwi.core.services.user.impl;

import com.esc.micro.kiwi.app.model.common.request.InfoRequest;
import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.app.model.common.user.UserIdentityAvailability;
import com.esc.micro.kiwi.app.model.common.user.UserProfile;
import com.esc.micro.kiwi.app.model.common.user.UserSummary;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.exception.CoreAppException;
import com.esc.micro.kiwi.core.model.common.role.Role;
import com.esc.micro.kiwi.core.model.common.role.RoleName;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.repositories.commons.RoleRepository;
import com.esc.micro.kiwi.core.repositories.user.UserRepository;
import com.esc.micro.kiwi.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {
  private static final Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

  @Resource
  private UserRepository userRepository;

  @Resource
  private RoleRepository roleRepository;

  @Resource
  private PasswordEncoder passwordEncoder;

  @Resource
  private MapperConverter<User, UserData> userDataMapperConverter;

  @Override

  public UserSummary getCurrentUser(UserPrincipalDetails currentUser) {
    return null;
  }

  @Override
  public UserIdentityAvailability checkUsernameAvailability(String username) {
    return null;
  }

  @Override
  public UserIdentityAvailability checkEmailAvailability(String email) {
    return null;
  }

  @Override
  public UserProfile getUserProfile(String username) {
    return null;
  }

  @Override
  public UserData addUser(UserData user) {
    List<Role> userRoles = new ArrayList<>();
    UserData newUserData;

    boolean isValidUser = userRepository.existsByUsername(user.getUsername())
        && userRepository.existsByEmail(user.getEmail());

    if (isValidUser) {
      LOG.error("user already exist!!!");
      return null;
    }

    Optional<Role> role = roleRepository.findByName(RoleName.ROLE_USER);

    if (role.isPresent())
      userRoles.add(role.get());
    else
      throw new CoreAppException("No user Role set");


    try {
      final User newUser = userDataMapperConverter.reverseConvert(user);
      newUser.setRoles(userRoles);
      newUser.setPassword(passwordEncoder.encode(user.getPassword()));

      // save new user
      newUserData = userDataMapperConverter.convert(userRepository.save(newUser));
    } catch (Exception exception) {
      newUserData = null;
    }

    return newUserData;
  }

  @Override
  public UserData updateUser(UserData newUser, String username, UserPrincipalDetails currentUser) {
    return null;
  }

  @Override
  public ApiResponse deleteUser(String username, UserPrincipalDetails currentUser) {
    return null;
  }

  @Override
  public ApiResponse giveAdmin(String username) {
    return null;
  }

  @Override
  public ApiResponse removeAdmin(String username) {
    return null;
  }

  @Override
  public UserProfile setOrUpdateInfo(UserPrincipalDetails currentUser, InfoRequest infoRequest) {
    return null;
  }

  @Override
  public List<UserData> getAllUsers() {
    Set<User> allUsers = userRepository.getAllByStatus();

    return userDataMapperConverter
        .convertAll(allUsers)
        .stream()
        .collect(Collectors.toList());
  }

  @Override
  public long getCountUsers() {
    return userRepository.getAllByStatus().size();
  }

  @Override
  public long getUsersPerDay() {
    return 0;
  }

  @Override
  public Boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public UserData addAdminUser(UserData userData) {

    List<Role> userAdminRoles = new ArrayList<>();

    Optional<Role> roleUser = roleRepository.findByName(RoleName.ROLE_USER);
    Optional<Role> roleAdmin = roleRepository.findByName(RoleName.ROLE_ADMIN);

    if (roleUser.isPresent() && roleAdmin.isPresent()) {
      userAdminRoles.add(roleUser.get());
      userAdminRoles.add(roleAdmin.get());
    } else {
      throw new CoreAppException("No Set Roles, please configure admin role");
    }

    User user = userDataMapperConverter.reverseConvert(userData);

    final StringBuilder userName = new StringBuilder();

    if (Objects.isNull(user.getUsername())) {
      final Random random = new SecureRandom();

      userName.append(StringUtils.capitalize(user.getFirstName()))
          .append(StringUtils.capitalize(user.getLastName()))
          .append(random.nextDouble());

      user.setUsername(userName.toString());
    }

    user.setRoles(userAdminRoles);

    return userDataMapperConverter.convert(userRepository.save(user));
  }

  @Override
  public UserData getUserById(Long id) {

    Optional<User> current = userRepository.findById(id);
    if (current.isPresent()) {
      return userDataMapperConverter.convert(current.get());
    } else {
      return null;
    }
  }
}

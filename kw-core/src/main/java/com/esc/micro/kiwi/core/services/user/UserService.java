package com.esc.micro.kiwi.core.services.user;

import com.esc.micro.kiwi.app.model.common.request.InfoRequest;
import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.app.model.common.user.UserIdentityAvailability;
import com.esc.micro.kiwi.app.model.common.user.UserProfile;
import com.esc.micro.kiwi.app.model.common.user.UserSummary;

import java.util.List;

public interface UserService {

  UserSummary getCurrentUser(UserPrincipalDetails currentUser);

  UserIdentityAvailability checkUsernameAvailability(String username);

  UserIdentityAvailability checkEmailAvailability(String email);

  UserProfile getUserProfile(String username);

  UserData addUser(UserData user);

  UserData updateUser(UserData newUser, String username, UserPrincipalDetails currentUser);

  ApiResponse deleteUser(String username, UserPrincipalDetails currentUser);

  ApiResponse giveAdmin(String username);

  ApiResponse removeAdmin(String username);

  UserProfile setOrUpdateInfo(UserPrincipalDetails currentUser, InfoRequest infoRequest);

  List<UserData> getAllUsers();

  long getCountUsers();

  long getUsersPerDay();

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  UserData addAdminUser(UserData userData);

  UserData getUserById(Long id);
}

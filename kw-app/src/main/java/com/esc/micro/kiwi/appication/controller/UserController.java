package com.esc.micro.kiwi.appication.controller;

import com.esc.micro.kiwi.app.model.common.request.InfoRequest;
import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.app.model.common.user.UserIdentityAvailability;
import com.esc.micro.kiwi.app.model.common.user.UserProfile;
import com.esc.micro.kiwi.app.model.common.user.UserSummary;
import com.esc.micro.kiwi.appication.security.jwt.CurrentUser;
import com.esc.micro.kiwi.appication.security.model.UserPrincipal;
import com.esc.micro.kiwi.core.services.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Resource
  private UserService userService;

  @GetMapping("/me")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<UserSummary> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    final UserPrincipalDetails userPrincipalDetails = new UserPrincipalDetails();
    //TODO MAP current user to user data
    UserSummary userSummary = userService.getCurrentUser(userPrincipalDetails);

    return new ResponseEntity<>(userSummary, HttpStatus.OK);
  }

  @GetMapping("/checkUsernameAvailability")
  public ResponseEntity<UserIdentityAvailability> checkUsernameAvailability(@RequestParam(value = "username") String username) {
    UserIdentityAvailability userIdentityAvailability = userService.checkUsernameAvailability(username);

    return new ResponseEntity<>(userIdentityAvailability, HttpStatus.OK);
  }

  @GetMapping("/checkEmailAvailability")
  public ResponseEntity<UserIdentityAvailability> checkEmailAvailability(@RequestParam(value = "email") String email) {
    UserIdentityAvailability userIdentityAvailability = userService.checkEmailAvailability(email);
    return new ResponseEntity<>(userIdentityAvailability, HttpStatus.OK);
  }

  @GetMapping("/{username}/profile")
  public ResponseEntity<UserProfile> getUSerProfile(@PathVariable(value = "username") String username) {
    UserProfile userProfile = userService.getUserProfile(username);

    return new ResponseEntity<>(userProfile, HttpStatus.OK);
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<UserData> addUser(@RequestBody UserData user) {
    UserData newUser = userService.addUser(user);

    if(newUser == null){
      return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @PutMapping("/{username}")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<UserData> updateUser(@RequestBody UserData newUser,
                                             @PathVariable(value = "username") String username, @CurrentUser UserPrincipal currentUser) {
    //TODO MAP current User
    final UserPrincipalDetails userPrincipalDetails = new UserPrincipalDetails();
    UserData updatedUSer = userService.updateUser(newUser, username, userPrincipalDetails);

    return new ResponseEntity<>(updatedUSer, HttpStatus.CREATED);
  }

  @DeleteMapping("/{username}")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "username") String username,
                                                @CurrentUser UserPrincipal currentUser) {

    //TODO MAP current User
    final UserPrincipalDetails userPrincipalDetails = new UserPrincipalDetails();
    ApiResponse apiResponse = userService.deleteUser(username, userPrincipalDetails);

    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
  }

  @PutMapping("/{username}/giveAdmin")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<ApiResponse> giveAdmin(@PathVariable(name = "username") String username) {
    ApiResponse apiResponse = userService.giveAdmin(username);

    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
  }

  @PutMapping("/{username}/takeAdmin")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<ApiResponse> takeAdmin(@PathVariable(name = "username") String username) {
    ApiResponse apiResponse = userService.removeAdmin(username);

    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
  }

  @PutMapping("/setOrUpdateInfo")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<UserProfile> setAddress(@CurrentUser UserPrincipal currentUser,
                                                @RequestBody InfoRequest infoRequest) {

    //TODO MAP current User
    final UserPrincipalDetails userPrincipalDetails = new UserPrincipalDetails();
    UserProfile userProfile = userService.setOrUpdateInfo(userPrincipalDetails, infoRequest);

    return new ResponseEntity<>(userProfile, HttpStatus.OK);
  }

}

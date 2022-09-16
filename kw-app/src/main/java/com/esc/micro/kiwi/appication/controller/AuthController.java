package com.esc.micro.kiwi.appication.controller;

import com.esc.micro.kiwi.app.model.common.request.LoginRequest;
import com.esc.micro.kiwi.app.model.common.request.SignUpRequest;
import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.response.JwtAuthenticationResponse;
import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.appication.security.jwt.JwtTokenProvider;
import com.esc.micro.kiwi.appication.utils.CreateExceptionSignature;
import com.esc.micro.kiwi.core.services.user.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.Auth_.*;
import static com.esc.micro.kiwi.appication.constants.ConstantsController.PathAPIRedirection.USERS_SUCCESS_REDIRECTION;

@RestController
@RequestMapping(BASE)
public class AuthController {
  @Resource
  private AuthenticationManager authenticationManager;

  @Resource
  private PasswordEncoder passwordEncoder;

  @Resource
  private JwtTokenProvider jwtTokenProvider;

  @Resource
  private UserService userService;

  @Resource
  private CreateExceptionSignature<ApiResponse> exceptionSignature;

  @PostMapping(LOGIN)
  public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication;

    try {
      authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));
    } catch (AuthenticationException exception) {
      ApiResponse response = exceptionSignature.createException(Boolean.FALSE, HttpStatus.FORBIDDEN, exception.getMessage());

      return createResponse(response);
    }

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = jwtTokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
  }

  @PostMapping(SIGNUP)
  public ResponseEntity<Object> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

    if (userService.existsByUsername(signUpRequest.getUsername())) {
      final ApiResponse response = exceptionSignature.createException(Boolean.FALSE, HttpStatus.BAD_REQUEST, "Username is already taken");
      return createResponse(response);
    }

    if (userService.existsByEmail(signUpRequest.getEmail())) {
      final ApiResponse response = exceptionSignature.createException(Boolean.FALSE, HttpStatus.BAD_REQUEST, "email is already taken");
      return createResponse(response);
    }

    String firstName = signUpRequest.getFirstName().toLowerCase();

    String lastName = signUpRequest.getLastName().toLowerCase();

    String email = signUpRequest.getEmail().toLowerCase();

    String password = passwordEncoder.encode(signUpRequest.getPassword());

    UserData userData = new UserData(firstName, lastName, signUpRequest.getUsername(), email, password);

    final UserData data = userService.addAdminUser(userData);

    URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path(USERS_SUCCESS_REDIRECTION).buildAndExpand(data.getUsername()).toUri();
    return ResponseEntity.created(location).body(new ApiResponse(Boolean.TRUE, "User registered successfully"));
  }

  private ResponseEntity createResponse(final ApiResponse apiResponse) {
    return new ResponseEntity(apiResponse, new HttpHeaders(), apiResponse.getStatus());
  }
}

package com.esc.micro.kiwi.core.services.user;

import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.UserData;

import java.util.Optional;

public interface DetailsUserService {
  Optional<UserPrincipalDetails> getCurrentUserDetail(String usernameOrEmail);

  UserData getUserById(Long id);

}

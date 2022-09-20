package com.esc.micro.kiwi.core.populators;

import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.core.model.common.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DetailsUserServicePopulator implements MapperPopulator<User, UserPrincipalDetails> {
  @Override
  public UserPrincipalDetails populate(User source, UserPrincipalDetails destination) {
    UserPrincipalDetails principalDetails = new UserPrincipalDetails();
    BeanUtils.copyProperties(source, principalDetails);
    return principalDetails;
  }
}

package com.esc.micro.kiwi.core.converters.user;

import com.esc.micro.kiwi.app.model.common.security.UserPrincipalDetails;
import com.esc.micro.kiwi.app.model.common.user.role.RoleData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.role.Role;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class DetailsUserServiceConverter extends AbstractValidator<User, UserPrincipalDetails> implements MapperConverter<User, UserPrincipalDetails> {

  @Resource
  private MapperConverter<Role, RoleData> roleDataMapperConverter;

  @Override
  public UserPrincipalDetails convert(User source) {
    if (validateType(User.class, UserPrincipalDetails.class)) {
      TypeMap<User, UserPrincipalDetails> propertyMapper = mapper.createTypeMap(User.class, UserPrincipalDetails.class);
      propertyMapper.addMapping(User::getEmail, UserPrincipalDetails::setEmail);
    }

    UserPrincipalDetails userPrincipalDetails = mapper.map(source, UserPrincipalDetails.class);

    userPrincipalDetails.setRoleDataSet(roleDataMapperConverter.convertAll(source.getRoles()));

    return userPrincipalDetails;
  }

  @Override
  public List<UserPrincipalDetails> convertAll(Collection<User> all) {
    List<UserPrincipalDetails> principalDetails = new ArrayList<>();
    for (User user : all) {
      principalDetails.add(convert(user));
    }
    return principalDetails;
  }

  @Override
  public User reverseConvert(UserPrincipalDetails source) {
    if (validateType(User.class, UserPrincipalDetails.class)) {
      TypeMap<UserPrincipalDetails, User> propertyMapper = mapper.createTypeMap(UserPrincipalDetails.class, User.class);
      propertyMapper.addMapping(UserPrincipalDetails::getEmail, User::setEmail);
    }
    return mapper.map(source, User.class);
  }
}

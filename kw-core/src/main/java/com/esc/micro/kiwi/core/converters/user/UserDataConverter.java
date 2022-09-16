package com.esc.micro.kiwi.core.converters.user;

import com.esc.micro.kiwi.app.model.common.user.UserData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.converters.user.roles.UserRoleConverter;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDataConverter extends AbstractValidator<User, UserData> implements MapperConverter<User, UserData> {

  @Resource
  private UserRoleConverter userRoleConverter;

  @Override
  public UserData convert(User source) {
    if (validateType(User.class, UserData.class)) {
      TypeMap<User, UserData> propertyMapper = mapper.createTypeMap(User.class, UserData.class);
      propertyMapper.addMapping(User::getEmail, UserData::setEmail);
      propertyMapper.addMapping(User::getLastName, UserData::setLastName);
    }
    final UserData userData = mapper.map(source, UserData.class);
    userData.setRoles(userRoleConverter.convertAll(source.getRoles()));

    return userData;
  }

  @Override
  public List<UserData> convertAll(Collection<User> all) {
    List<UserData> dataCollection = new ArrayList<>();
    for (User user : all) {
      dataCollection.add(convert(user));
    }
    return dataCollection;
  }

  @Override
  public User reverseConvert(UserData source) {
    if (validateType(User.class, UserData.class)) {
      TypeMap<UserData, User> propertyMapper = mapper.createTypeMap(UserData.class, User.class);
      propertyMapper.addMapping(UserData::getEmail, User::setEmail);
    }
    return mapper.map(source, User.class);
  }

}

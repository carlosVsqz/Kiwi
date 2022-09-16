package com.esc.micro.kiwi.core.converters.user.roles;

import com.esc.micro.kiwi.app.model.common.user.role.RoleData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.role.Role;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;


@Component
public class UserRoleConverter extends AbstractValidator<Role, RoleData> implements MapperConverter<Role, RoleData> {

  @Override
  public RoleData convert(Role source) {
    if (validateType(Role.class, RoleData.class)) {
      TypeMap<Role, RoleData> typeMap = mapper.createTypeMap(Role.class, RoleData.class);
      typeMap.addMapping(Role::getName, RoleData::setName);
    }
    return mapper.map(source, RoleData.class);
  }

  @Override
  public List<RoleData> convertAll(Collection<Role> all) {
    return mapper.map(all, new TypeToken<Collection<RoleData>>() {
    }.getType());
  }

  @Override
  public Role reverseConvert(RoleData source) {
    return mapper.map(source, Role.class);
  }
}

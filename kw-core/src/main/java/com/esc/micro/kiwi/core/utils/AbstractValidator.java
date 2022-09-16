package com.esc.micro.kiwi.core.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import javax.annotation.Resource;

public abstract class AbstractValidator<T, S> {
  @Resource
  protected ModelMapper mapper;

  public boolean validateType(Class<T> type, Class<S> otherType) {
    TypeMap<T, S> typeMap = mapper.getTypeMap(type, otherType);

    return typeMap == null ? Boolean.TRUE : Boolean.FALSE;
  }
}

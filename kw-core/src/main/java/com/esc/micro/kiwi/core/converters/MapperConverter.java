package com.esc.micro.kiwi.core.converters;

import java.util.Collection;
import java.util.List;

public interface MapperConverter<S, T> {

  T convert(S source);

  List<T> convertAll(Collection<S> all);

  S reverseConvert(T source);
}

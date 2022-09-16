package com.esc.micro.kiwi.appication.mapper;

public interface Mapper<S, T> {

  T convert(S source, T target);
}
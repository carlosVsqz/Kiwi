package com.esc.micro.kiwi.core.populators;

public interface MapperPopulator<S, T> {
  T populate(S source, T destination);

}

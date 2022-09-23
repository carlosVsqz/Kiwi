package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.core.repositories.commons.CategoryRepository;
import com.esc.micro.kiwi.core.services.common.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefaultCategoryService implements CategoryService {

  @Resource
  private CategoryRepository categoryRepository;

  @Override
  public int getCountPostsByCategoryId(Long id) {
    return categoryRepository.countPostsByCategoryId(id);
  }
}

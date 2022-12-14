package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.repositories.commons.CategoryRepository;
import com.esc.micro.kiwi.core.services.common.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryService implements CategoryService {

  @Resource
  private CategoryRepository categoryRepository;



  @Override
  public int getCountPostsByCategoryId(Long id) {
    return categoryRepository.countPostsByCategoryId(id);
  }
}

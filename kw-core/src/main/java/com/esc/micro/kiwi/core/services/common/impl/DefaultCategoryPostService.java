package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.repositories.commons.CategoryRepository;
import com.esc.micro.kiwi.core.services.common.CategoryPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryPostService implements CategoryPostService {

  @Resource
  private MapperConverter<Category, CategoryData> categoryDataMapperConverter;

  @Resource
  private CategoryRepository categoryRepository;


  @Override
  public List<CategoryData> getAvailableCategories() {
    List<Category> categoryList = new ArrayList<>();

    final Pageable page = PageRequest.of(0, 10);

    Page<Category> categories = categoryRepository.findAll(page);
    if (categories != null) {
      categoryList.addAll(categories.get().collect(Collectors.toList()));
    }
    return categoryDataMapperConverter.convertAll(categoryList);
  }
}

package com.esc.micro.kiwi.core.converters.common.category;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CategoryDataConverter extends AbstractValidator<Category, CategoryData> implements MapperConverter<Category, CategoryData> {
  @Override
  public CategoryData convert(Category source) {
    return mapper.map(source, CategoryData.class);
  }

  @Override
  public List<CategoryData> convertAll(Collection<Category> all) {
    return mapper.map(all, new TypeToken<Collection<CategoryData>>() {
    }.getType());
  }

  @Override
  public Category reverseConvert(CategoryData source) {
    return mapper.map(source, Category.class);
  }
}

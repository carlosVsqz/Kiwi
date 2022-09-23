package com.esc.micro.kiwi.core.converters.common.category;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.app.model.common.response.post.PostData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.services.common.CategoryService;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CategoryDataConverter extends AbstractValidator<Category, CategoryData> implements MapperConverter<Category, CategoryData> {

  @Resource
  private CategoryService categoryService;

  @Override
  public CategoryData convert(Category source) {
    if (validateType(Category.class, CategoryData.class)) {
      TypeMap<Category, CategoryData> typeMap = mapper.createTypeMap(Category.class, CategoryData.class);
      typeMap.addMapping(Category::getId, CategoryData::setId);
      typeMap.addMapping(Category::getName, CategoryData::setName);
      typeMap.addMapping(Category::getKey, CategoryData::setKey);
      typeMap.addMapping(Category::getImage, CategoryData::setImage);
    }

    CategoryData categoryData = mapper.map(source, CategoryData.class);
    int count = categoryService.getCountPostsByCategoryId(source.getId());

    categoryData.setQuantity(String.valueOf(count));
    return categoryData;
  }

  @Override
  public List<CategoryData> convertAll(Collection<Category> all) {
//    return mapper.map(all, new TypeToken<Collection<CategoryData>>() {}.getType());
    List<CategoryData> data = new ArrayList<>();
    for (Category category : all) {
      data.add(convert(category));
    }
    return data;
  }

  @Override
  public Category reverseConvert(CategoryData source) {
    return mapper.map(source, Category.class);
  }
}

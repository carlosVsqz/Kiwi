package com.esc.micro.kiwi.core.services.common;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;

import java.util.List;

public interface CategoryPostService {
  List<CategoryData> getAvailableCategories();
}

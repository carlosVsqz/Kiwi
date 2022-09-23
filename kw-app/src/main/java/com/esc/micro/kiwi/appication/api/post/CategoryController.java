package com.esc.micro.kiwi.appication.api.post;

import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.appication.api.Manager;
import com.esc.micro.kiwi.appication.utils.CreateExceptionSignature;
import com.esc.micro.kiwi.core.services.common.CategoryPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.Post_.BASE_CATEGORIES;
import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.Post_.BASE_POST;

@RestController
@RequestMapping(BASE_POST + BASE_CATEGORIES)
public class CategoryController<T> extends Manager {

  @Resource
  private CreateExceptionSignature<ApiResponse> exceptionSignature;

  @Resource
  private CategoryPostService categoryService;

  @GetMapping
  public ResponseEntity<T> getCurrentPostCategories() {
    try {
      List<CategoryData> categoryData = categoryService.getAvailableCategories();
      return (ResponseEntity<T>) ResponseEntity.ok(categoryData);
    } catch (Exception exception) {
      final ApiResponse response = exceptionSignature.createException(Boolean.FALSE, HttpStatus.BAD_REQUEST, "error al obtener categories: " + exception.getMessage());
      return createResponseApi(response);
    }
  }
}

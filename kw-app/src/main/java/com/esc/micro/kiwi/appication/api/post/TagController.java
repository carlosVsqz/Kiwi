package com.esc.micro.kiwi.appication.api.post;

import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.response.post.TagData;
import com.esc.micro.kiwi.appication.api.Manager;
import com.esc.micro.kiwi.appication.utils.CreateExceptionSignature;
import com.esc.micro.kiwi.core.services.common.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.Post_.BASE_POST;
import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.Post_.BASE_TAG;

@RestController
@RequestMapping(BASE_POST + BASE_TAG)
public class TagController<T> extends Manager {

  @Resource
  private CreateExceptionSignature<ApiResponse> exceptionSignature;

  @Resource
  private TagService tagService;


  @GetMapping()
  public ResponseEntity<T> getAvailableTags() {
    try {
      List<TagData> tagData = tagService.getAvailableTags();

      return (ResponseEntity<T>) ResponseEntity.ok(tagData);
    } catch (Exception exception) {
      final ApiResponse response = exceptionSignature.createException(Boolean.FALSE, HttpStatus.BAD_REQUEST, "error al obtener tags: " + exception.getMessage());
      return createResponseApi(response);
    }
  }
}

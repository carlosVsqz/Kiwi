package com.esc.micro.kiwi.appication.api.post;

import com.esc.micro.kiwi.app.model.common.response.ApiResponse;
import com.esc.micro.kiwi.app.model.common.response.post.PostData;
import com.esc.micro.kiwi.appication.api.Manager;
import com.esc.micro.kiwi.appication.utils.CreateExceptionSignature;
import com.esc.micro.kiwi.core.services.common.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import java.util.List;

import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.LIMIT;
import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.Post_.BASE_POST;
import static com.esc.micro.kiwi.appication.constants.ConstantsController.ControllerConstants.ApiEndPoints.TYPE_LIKE;

@RestController
@RequestMapping(BASE_POST)
public class PostController<T> extends Manager {

  @Resource
  private CreateExceptionSignature<ApiResponse> exceptionSignature;

  @Resource
  private PostService postService;

  @GetMapping
  ResponseEntity<T> getPosts(@RequestParam(required = false, name = LIMIT, defaultValue = "12") final int _limit,
                             @RequestParam(required = false, name = TYPE_LIKE) final String type) {
    ///posts?_limit=3&type_like=image
    try {

      List<PostData> posts = postService.getPosts(_limit, type);

      return (ResponseEntity<T>) ResponseEntity.ok(posts);
    } catch (Exception exception) {
      final ApiResponse response = exceptionSignature.createException(Boolean.FALSE, HttpStatus.BAD_REQUEST, "error al obtener posts: " + exception.getMessage());
      return createResponseApi(response);
    }
  }

  @PostMapping
  ResponseEntity<T> createPost(){
    return null;
  }

}

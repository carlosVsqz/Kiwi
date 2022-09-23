package com.esc.micro.kiwi.appication.constants;

public final class ConstantsController {
  public static final String tokenType = "Bearer";

  public interface ControllerConstants {
    interface ApiEndPoints {
      String LIMIT = "_limit";
      String TYPE_LIKE = "_limit";

      interface Auth_ {
        String BASE = "/api";
        String LOGIN = "/auth/login";
        String SIGNUP = "/auth/signup";
      }

      interface Index_ {

      }

      interface Post_ {
        String BASE_POST = "/posts";
        String BASE_CATEGORIES = "/categories";
        String BASE_TAG = "/tag";

        String _POST_GET_ONE = "/{postId}";
      }

      interface Project_ {

      }

      interface User_ {

      }
    }
  }

  public static class PathAPIRedirection {
    public static final String USERS_SUCCESS_REDIRECTION = "/api/users/{username}";
  }
}

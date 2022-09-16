package com.esc.micro.kiwi.appication.constants;

public final class ConstantsController {
  public static final String tokenType = "Bearer";

  public static class PathAPIRedirection {
    public static final String USERS_SUCCESS_REDIRECTION = "/api/users/{username}";
  }

  public interface ControllerConstants {
    interface ApiEndPoints {
      interface Auth_ {
        String BASE = "/api";
        String LOGIN = "/auth/login";
        String SIGNUP = "/auth/signup";
      }

      interface Index_ {

      }

      interface Post_ {

      }

      interface Project_ {

      }

      interface User_ {

      }
    }
  }
}

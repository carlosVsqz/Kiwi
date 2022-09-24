package com.esc.micro.kiwi.core.services.common;

import com.esc.micro.kiwi.app.model.common.post.NewPostData;
import com.esc.micro.kiwi.app.model.common.response.post.PostData;
import com.esc.micro.kiwi.app.model.exception.PostException;

import java.util.List;
import java.util.Optional;

public interface PostService <T> {
  List<PostData> getPosts(Integer limit, String type);

  Optional<PostData> getPostById(Long id);

  T createPost(NewPostData postData, String emailUser) throws PostException;

  List<PostData> getUnapprovedPosts(Integer limit, String type);

  PostData approvePost(Long postId) throws PostException;
}

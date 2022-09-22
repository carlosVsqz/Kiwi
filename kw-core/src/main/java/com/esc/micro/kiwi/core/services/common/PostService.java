package com.esc.micro.kiwi.core.services.common;

import com.esc.micro.kiwi.app.model.common.response.post.PostData;

import java.util.List;

public interface PostService {
  List<PostData> getPosts(Integer limit, String type);
}

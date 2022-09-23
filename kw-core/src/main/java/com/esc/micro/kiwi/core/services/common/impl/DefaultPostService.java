package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.response.post.PostData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.repositories.commons.PostRepository;
import com.esc.micro.kiwi.core.services.common.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultPostService implements PostService {

  @Resource
  private PostRepository postRepository;

  @Resource
  private MapperConverter<Post, PostData> postPostDataMapper;

  @Override
  public List<PostData> getPosts(Integer limit, String type) {
    Assert.notNull(limit, "null limit, set default max page");
    List<Post> posts = new ArrayList<>();


    if (limit > 0) {
      final Pageable page = PageRequest.of(0, limit);
      Page<Post> postPage = postRepository.findAll(page);
      if (postPage != null) {
        posts.addAll(postPage.get().collect(Collectors.toList()));
      }
    }

    return postPostDataMapper.convertAll(posts);
  }

  @Override
  public Optional<PostData> getPostById(Long id) {
    Optional<PostData> post;

    Optional<Post> optionalPost = postRepository.findById(id);

    post = Optional.ofNullable(postPostDataMapper.convert(optionalPost.get()));

    return post;
  }

}

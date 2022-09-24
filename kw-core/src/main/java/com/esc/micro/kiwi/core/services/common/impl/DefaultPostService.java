package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.post.NewPostData;
import com.esc.micro.kiwi.app.model.common.response.post.PostData;
import com.esc.micro.kiwi.app.model.exception.PostException;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.model.common.service.Tag;
import com.esc.micro.kiwi.core.model.common.user.User;
import com.esc.micro.kiwi.core.repositories.commons.CategoryRepository;
import com.esc.micro.kiwi.core.repositories.commons.PostRepository;
import com.esc.micro.kiwi.core.repositories.commons.TagRepository;
import com.esc.micro.kiwi.core.repositories.user.UserRepository;
import com.esc.micro.kiwi.core.services.common.PostService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultPostService implements PostService {

  @Resource
  private PostRepository postRepository;

  @Resource
  private MapperConverter<Post, PostData> postPostDataMapper;

  @Resource
  private TagRepository tagRepository;

  @Resource
  private CategoryRepository categoryRepository;

  @Resource
  private UserRepository userRepository;

  @Resource
  private ModelMapper mapper;

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

  @Override
  public PostData createPost(NewPostData postData, String emailUser) throws PostException {

    if (Objects.isNull(postData))
      throw new PostException("no existe ningún objeto valido a guardar");

    Post post = new Post();

    mapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);

    TypeMap<NewPostData, Post> typeMap = mapper.getTypeMap(NewPostData.class, Post.class);

    if (typeMap == null) {
      TypeMap<NewPostData, Post> propertyMapper = this.mapper.createTypeMap(NewPostData.class, Post.class);
      propertyMapper.addMappings(mapper -> mapper.skip(Post::setId));
      propertyMapper.addMappings(mapper -> mapper.skip(Post::setCategories));
      propertyMapper.addMappings(mapper -> mapper.skip(Post::setTags));

    }

    mapper.map(postData, post);

    //get tags by id in post
    if (!postData.getTags().isEmpty()) {
      List<Tag> tags;
      try {
        tags = tagRepository.findAllById(postData.getTagsListId());
      } catch (Exception exception) {
        throw new PostException("No se encontraron tags validos dentro del nuevo post");
      }

      post.setTags(Set.copyOf(tags));
    }

    // get categories by id in posts;
    if (!postData.getCategories().isEmpty()) {
      List<Category> categories;

      try {
        categories = categoryRepository.findAllById(postData.getCategoryListId());
      } catch (Exception exception) {
        throw new PostException("No se encontraron categorias validas dentro del nuevo post");
      }
      post.setCategories(Set.copyOf(categories));
    }

    //set user
    if (!emailUser.isEmpty()) {
      try {
        Optional<User> user = userRepository.findByEmail(emailUser);
        if (user.isPresent())
          post.setUser(user.get());
        else
          throw new Exception("no existe el usuario con cual crear el post");
      } catch (Exception exception) {
        throw new PostException("Error al obtener el usuario: " + exception.getMessage());
      }
    }

    post.setPublicDate(new Date());

    try {
      postRepository.saveAndFlush(post);
    } catch (Exception exception) {
      throw new PostException("Error al guardar el nuevo post");
    }

    return postPostDataMapper.convert(post);
  }

  @Override
  public List<PostData> getUnapprovedPosts(Integer limit, String type) {
    Assert.notNull(limit, "null limit, set default max page");
    List<Post> posts = new ArrayList<>();


    if (limit > 0) {
      final Pageable page = PageRequest.of(0, limit);
      Page<Post> postPage = postRepository.findAllUnapproved(page);
      if (postPage != null) {
        posts.addAll(postPage.get().collect(Collectors.toList()));
      }
    }

    return postPostDataMapper.convertAll(posts);
  }

  @Override
  public PostData approvePost(Long postId) throws PostException {
    Optional<Post> post;

    Post updatedPost;

    post = postRepository.findByUnapprovedById(postId);

    if (post.isPresent()) {
      updatedPost = post.get();

      if (updatedPost.getStatus() == false) {
        updatedPost.setStatus(Boolean.TRUE);
      } else {
        throw new PostException("el post ya se encuentra aprobado");
      }

      try {
        postRepository.save(updatedPost);
      } catch (Exception exception) {
        throw new PostException("Error al guardar el post con id: " + updatedPost.getId());
      }
    } else {
      throw new PostException("No existe un post con el id: " + postId + " o se encuentra aprobado");
    }

    return postPostDataMapper.convert(updatedPost);
  }

}

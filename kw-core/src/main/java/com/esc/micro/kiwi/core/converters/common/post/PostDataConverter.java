package com.esc.micro.kiwi.core.converters.common.post;

import com.esc.micro.kiwi.app.model.common.response.category.CategoryData;
import com.esc.micro.kiwi.app.model.common.response.post.PostData;
import com.esc.micro.kiwi.app.model.common.response.post.TagData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Category;
import com.esc.micro.kiwi.core.model.common.service.Post;
import com.esc.micro.kiwi.core.model.common.service.Tag;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class PostDataConverter extends AbstractValidator<Post, PostData> implements MapperConverter<Post, PostData> {

  @Resource
  private MapperConverter<Tag, TagData> tagDataMapper;

  @Resource
  private MapperConverter<Category, CategoryData> categoryDataMapper;

  @Override
  public PostData convert(Post source) {
    if (validateType(Post.class, PostData.class)) {
      TypeMap<Post, PostData> typeMap = mapper.createTypeMap(Post.class, PostData.class);
      typeMap.addMapping(Post::getTitle, PostData::setTitle);
    }
    final PostData postData = mapper.map(source, PostData.class);

    postData.setTags(tagDataMapper.convertAll(source.getTags()));
    postData.setCategory(categoryDataMapper.convertAll(source.getCategories()));

    return postData;
  }

  @Override
  public List<PostData> convertAll(Collection<Post> all) {
//    return mapper.map(all, new TypeToken<Collection<PostData>>() {}.getType());
    List<PostData> postDataList = new ArrayList<>();
    for (Post post : all) {
      postDataList.add(convert(post));
    }
    return postDataList;
  }

  @Override
  public Post reverseConvert(PostData source) {
    return mapper.map(source, Post.class);
  }
}

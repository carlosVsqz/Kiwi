package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.response.post.TagData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Tag;
import com.esc.micro.kiwi.core.repositories.commons.TagRepository;
import com.esc.micro.kiwi.core.services.common.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultTagService implements TagService {

  @Resource
  private TagRepository tagRepository;

  @Resource
  private MapperConverter<Tag, TagData> tagDataMapperConverter;

  @Override
  public List<TagData> getAvailableTags() {

    List<Tag> tags = new ArrayList<>();

    final Pageable page = PageRequest.of(0, 4);

    Page<Tag> tagPage = tagRepository.findAll(page);

    if (tagPage != null) {
      tags.addAll(tagPage.get().collect(Collectors.toList()));
    }

    return tagDataMapperConverter.convertAll(tags);
  }
}

package com.esc.micro.kiwi.core.converters.common.post;

import com.esc.micro.kiwi.app.model.common.response.post.TagData;
import com.esc.micro.kiwi.core.converters.MapperConverter;
import com.esc.micro.kiwi.core.model.common.service.Tag;
import com.esc.micro.kiwi.core.utils.AbstractValidator;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class TagDataConverter extends AbstractValidator<Tag, TagData> implements MapperConverter<Tag, TagData> {
  @Override
  public TagData convert(Tag source) {
    return mapper.map(source, TagData.class);
  }

  @Override
  public List<TagData> convertAll(Collection<Tag> all) {
    return mapper.map(all, new TypeToken<Collection<TagData>>() {
    }.getType());
  }

  @Override
  public Tag reverseConvert(TagData source) {
    return mapper.map(source, Tag.class);
  }
}

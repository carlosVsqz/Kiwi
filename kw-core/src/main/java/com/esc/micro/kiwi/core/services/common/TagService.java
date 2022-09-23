package com.esc.micro.kiwi.core.services.common;

import com.esc.micro.kiwi.app.model.common.response.post.TagData;

import java.util.List;

public interface TagService {
  List<TagData> getAvailableTags();

}

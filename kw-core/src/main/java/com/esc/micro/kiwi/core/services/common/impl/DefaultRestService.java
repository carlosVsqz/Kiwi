package com.esc.micro.kiwi.core.services.common.impl;

import com.esc.micro.kiwi.app.model.common.response.SiteStatResponse;
import com.esc.micro.kiwi.core.services.common.RestService;
import org.springframework.stereotype.Service;

@Service
public class DefaultRestService implements RestService {
  @Override
  public SiteStatResponse getIndexData() {
    return null;
  }
}

package com.esc.micro.kiwi.appication.controller;

import com.esc.micro.kiwi.app.model.common.response.SiteStatResponse;
import com.esc.micro.kiwi.core.services.common.RestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/site-stat")
public class IndexController {

  @Resource
  private RestService restService;

  @GetMapping
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<Object> publicIndexEndPoint() {
    SiteStatResponse response = restService.getIndexData();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}

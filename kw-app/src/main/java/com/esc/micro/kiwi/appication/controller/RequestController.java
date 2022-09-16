package com.esc.micro.kiwi.appication.controller;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestController implements ErrorController {

    org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RequestController.class);

    @GetMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        int code = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Map<String, Object> body = new HashMap<>();
        body.put("code", code);
        body.put("message", HttpStatus.valueOf(code));
        return ResponseEntity.ok(body);
    }

    @GetMapping("/")
    public ResponseEntity<Object> homePath(){
        return ResponseEntity.ok(":D");
    }
}

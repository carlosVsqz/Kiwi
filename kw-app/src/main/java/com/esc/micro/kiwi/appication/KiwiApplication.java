package com.esc.micro.kiwi.appication;

import com.esc.micro.kiwi.appication.security.jwt.JwtAuthenticationFilter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KiwiApplication {

  public static void main(String[] args) {
    SpringApplication.run(KiwiApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

//  @Bean
//  public JwtAuthenticationFilter jwtAuthenticationFilter() {
//    return new JwtAuthenticationFilter();
//  }

}

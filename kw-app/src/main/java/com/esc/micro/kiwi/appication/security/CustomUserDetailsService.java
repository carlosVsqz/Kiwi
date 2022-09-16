package com.esc.micro.kiwi.appication.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {

	UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

	UserDetails loadUserById(Long id);

}

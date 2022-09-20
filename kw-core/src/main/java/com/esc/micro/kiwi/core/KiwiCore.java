package com.esc.micro.kiwi.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.esc.micro.kiwi.core.model")
//@EnableJpaRepositories(basePackages = "com.esc.micro.kiwi.core.repositories")
@EnableTransactionManagement
public class KiwiCore {
}

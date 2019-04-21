package ru.myuniversity.admissionrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "ru.myuniversity.admissionrest.repository")
@Configuration
public class Config {
}

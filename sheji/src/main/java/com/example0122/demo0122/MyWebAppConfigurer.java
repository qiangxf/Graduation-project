package com.example0122.demo0122;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Users/qxf/IdeaProjects/Graduation-project/sheji/src/main/resources/**").addResourceLocations("classpath:");
        super.addResourceHandlers(registry);
    }
}

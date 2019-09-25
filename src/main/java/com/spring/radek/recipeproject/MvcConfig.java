package com.spring.radek.recipeproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/400error").setViewName("400error");
        registry.addViewController("/404error").setViewName("404error");
        registry.addViewController("/recipe").setViewName("recipe");
        registry.addViewController("/login").setViewName("login");
    }

}

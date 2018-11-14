package com.shop.config;


import com.shop.common.handler.CommonExceptionHandler;
import com.shop.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 配置
 */
@Configuration
public class AdminConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public CommonExceptionHandler commonExceptionHandler(){
        return new CommonExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/auth/**").addResourceLocations("classpath:/auth/");
        super.addResourceHandlers(registry);
    }

    @Bean
    JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }


}

package com.example.dm_demo.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    // 添加CorsFilter拦截器，对任意的请求使用
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        // 允许跨域的头部信息
        config.addAllowedHeader("*");
        // 允许跨域的方法
        config.addAllowedMethod("*");
        // 可访问的外部域
        config.addAllowedOrigin("*");
        // 需要跨域用户凭证（cookie、HTTP认证及客户端SSL证明等）
        //config.setAllowCredentials(true);
        //config.addAllowedOriginPattern("*");

        // 跨域路径配置
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean cros = new FilterRegistrationBean(new CorsFilter(source));
        cros.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return new CorsFilter(source);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域路径
        CorsRegistration cors = registry.addMapping("/**");

        // 可访问的外部域
        cors.allowedOrigins("*");
        // 支持跨域用户凭证
        //cors.allowCredentials(true);
        //cors.allowedOriginPatterns("*");
        // 设置 header 能携带的信息
        cors.allowedHeaders("*");
        // 支持跨域的请求方法
        cors.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
        // 设置跨域过期时间，单位为秒
        cors.maxAge(3600);


    }


    @Bean
    public HttpMessageConverters httpMessageConverters() {
        return new HttpMessageConverters(
            Arrays.asList(
                new StringHttpMessageConverter(Charset.forName("UTF-8")),
                //new FastJsonHttpMessageConverter(),
                new MappingJackson2HttpMessageConverter())
        );
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}

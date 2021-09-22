package com.brisk.farm_serve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

/**
 * WebCorsConfiguration 跨域配置
 *
 * @author star
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 设置swagger为默认主页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        设置主页：将“/”重定向至主页
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
//        映射时处理顺序级别最高
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        添加到视图控制器
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    @Bean
    public CorsFilter corsFilter() {
//        CorsUrl路径配置
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        Cors配置
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
//        singletonList快速创建list
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        // 暴露 header 中的其他属性给客户端应用程序
        config.setExposedHeaders(Arrays.asList(
                "Authorization", "X-Total-Count", "Link",
                "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials"
        ));
//        为指定config注册 CorsConfiguration。
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}

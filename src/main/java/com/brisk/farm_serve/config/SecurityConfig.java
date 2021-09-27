package com.brisk.farm_serve.config;

import org.springframework.data.redis.core.StringRedisTemplate;
import com.brisk.farm_serve.constants.SecurityConstants;
import com.brisk.farm_serve.exception.JwtAccessDeniedHandler;
import com.brisk.farm_serve.exception.JwtAuthenticationEntryPoint;
import com.brisk.farm_serve.filter.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;


/**
 * SpringSecurity 配置
 */
@EnableWebSecurity          // 使用表达式时间方法级别的安全性 4个注解可用
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 配置Redis
    private final StringRedisTemplate stringRedisTemplate;

    public SecurityConfig(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    /**
     * 密码编码器
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                //添加CorsFilter  会使用下面的CorsFilter配置
                cors(withDefaults())
                // 禁用 CSRF
                .csrf().disable()
                // 使用 RequestMatcher 实现（即通过 URL 模式）基于 HttpServletRequest 限制访问。
                .authorizeRequests()
                // 放行接口
                // swagger
                .antMatchers(SecurityConstants.SWAGGER_WHITELIST).permitAll()
                // H2
                .antMatchers(SecurityConstants.H2_CONSOLE).permitAll()
                // system
                .antMatchers(HttpMethod.POST, SecurityConstants.SYSTEM_WHITELIST).permitAll()
                // 其他的接口都需要认证后才能请求
                .anyRequest().authenticated()
                .and()
                //添加自定义Filter  Jwt
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), stringRedisTemplate))
                //允许配置会话管理 指定 SessionCreationPolicy 设定会话创建策略 STATELESS
                // 不需要session（不创建会话）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 配置异常处理
                // 授权异常处理
                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                .accessDeniedHandler(new JwtAccessDeniedHandler());
        // 防止H2 web 页面的Frame 被拦截
        http.headers().frameOptions().disable();
    }

    /**
     * Cors配置
     **/
    @Bean
    public CorsFilter corsFilter() {
        // CorsUrl路径配置
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Cors配置
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // singletonList快速创建list
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        // 暴露 header 中的其他属性给客户端应用程序
        config.setExposedHeaders(Arrays.asList(
                "Authorization", "X-Total-Count", "Link",
                "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials"
        ));
        // 为指定config注册 CorsConfiguration。
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}

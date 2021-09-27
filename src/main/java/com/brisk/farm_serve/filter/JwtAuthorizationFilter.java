package com.brisk.farm_serve.filter;


import com.brisk.farm_serve.constants.SecurityConstants;
import com.brisk.farm_serve.util.JwtTokenUtils;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器处理所有HTTP请求，并检查是否存在带有正确令牌的Authorization标头。例如，如果令牌未过期或签名密钥正确。
 */
@Slf4j
// 继承BasicAuthenticationFilter: 用来处理HTTPBasic登录的。检查请求的请求头中是不是有Basic开头的authentication的信息
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final StringRedisTemplate stringRedisTemplate;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, StringRedisTemplate stringRedisTemplate) {
        super(authenticationManager);
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        // 获取TOKEN值
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
        // 如果获取不到
        if (token == null || !token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            SecurityContextHolder.clearContext();
            // 调用下一个过滤器
            chain.doFilter(request, response);
            return;
        }
        // 消除前缀：Bearer
        String tokenValue = token.replace(SecurityConstants.TOKEN_PREFIX, "");
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            // 先前的token存在redis中
            // 从redis 中获取对应的ID存储的token
            String previousToken = stringRedisTemplate.opsForValue().get(JwtTokenUtils.getId(tokenValue));
            // 如果token与存储中的token不一致
            if (!token.equals(previousToken)) {
                SecurityContextHolder.clearContext();
                // 调用下一个过滤器
                chain.doFilter(request, response);
                return;
            }
            // 通过token获取一个被请求验证对象
            authentication = JwtTokenUtils.getAuthentication(tokenValue);
        } catch (JwtException e) {
            logger.error("Invalid jwt : " + e.getMessage());
        }
        // SecurityContext中setAuthentication  设置当前经过身份验证的主体
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}

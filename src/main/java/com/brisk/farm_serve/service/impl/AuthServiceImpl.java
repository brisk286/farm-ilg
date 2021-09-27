package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.bo.JwtUser;
import com.brisk.farm_serve.pojo.bo.LoginRequest;
import com.brisk.farm_serve.pojo.po.User;
import com.brisk.farm_serve.service.AuthService;
import com.brisk.farm_serve.util.CurrentUserUtils;
import com.brisk.farm_serve.util.JwtTokenUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CurrentUserUtils currentUserUtils;

    @Override
    public String createToken(LoginRequest loginRequest) {
        // 通过username获取User
        User user = userService.findUserByUserName(loginRequest.getUsername());
        // 验证登录密码和系统中保存加密密码是否匹配
        if (!userService.check(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("The user name or password is not correct.");
        }
        // JWT用户对象 实现了UserDetails
        JwtUser jwtUser = new JwtUser(user);
        jwtUser.setAuthorities(userService.getRoles(user));
        // 用户是否被拉黑
        if (!jwtUser.isEnabled()) {
            throw new BadCredentialsException("User is forbidden to login");
        }
        // 获得User对应的Authorities并授权
        List<String> authorities = jwtUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        // token中包含username。id，roles, rememberMe影响过期时间
        System.out.println(authorities);
        String token = JwtTokenUtils.createToken(user.getUser_name(), user.getUser_id().toString(), authorities, loginRequest.getRememberMe());
        // 将（userId， token）保存到redis中
        stringRedisTemplate.opsForValue().set(user.getUser_id().toString(), token);
        return token;
    }

    @Override
    // 从redis中删除token记录
    public void removeToken() {
        stringRedisTemplate.delete(currentUserUtils.getCurrentUser().getUser_id().toString());
    }
}

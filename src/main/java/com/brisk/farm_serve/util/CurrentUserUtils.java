package com.brisk.farm_serve.util;

import com.brisk.farm_serve.pojo.po.User;
import com.brisk.farm_serve.service.UserService;
import com.brisk.farm_serve.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 获取当前请求的用户
 * @author shuang.kou
 */
@Component
public class CurrentUserUtils {

    @Autowired
    private UserService userService;

    public User getCurrentUser() {
        // 获取当前经过身份验证的主体
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            // 获取被验证主体的身份 通常是用户名
            return userService.findUserByUserName((String) authentication.getPrincipal());
        }
        return null;
    }
}

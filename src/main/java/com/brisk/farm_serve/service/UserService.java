package com.brisk.farm_serve.service;

import com.brisk.farm_serve.entity.PageRequest;
import com.brisk.farm_serve.entity.PageResult;
import com.brisk.farm_serve.entity.User;
import com.brisk.farm_serve.request.UserRegisterRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public interface UserService {

    void save(UserRegisterRequest userRegisterRequest);

    public List<SimpleGrantedAuthority> getRoles(User user);

    public PageResult findUserWithPage(PageRequest pageRequest);

    public boolean check(String currentPassword, String password);

    public void ensureUserNameNotExist(String userName);

    public User findUserByUserName(String username);
}

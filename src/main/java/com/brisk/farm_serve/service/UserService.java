package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.bo.PageRequest;
import com.brisk.farm_serve.pojo.dto.PageResult;
import com.brisk.farm_serve.pojo.po.User;
import com.brisk.farm_serve.pojo.bo.UserRegisterRequest;
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

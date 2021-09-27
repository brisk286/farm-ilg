package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.entity.User;
import com.brisk.farm_serve.mbg.mapper.UserMapper;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(Long user_id) {
         return userMapper.getUserByUserId(user_id);
    }
}

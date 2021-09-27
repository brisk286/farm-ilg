package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.entity.PageRequest;
import com.brisk.farm_serve.entity.PageResult;
import com.brisk.farm_serve.entity.User;
import com.brisk.farm_serve.mbg.mapper.UserMapper;
import com.brisk.farm_serve.representation.UserRepresentation;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.UserInfoService;
import com.brisk.farm_serve.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户: User")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{user_id}")
    @ApiOperation(value = "查询用户")
    public CommonResult<User> getUserById(@PathVariable(value = "user_id") Long user_id){
        User user = userInfoService.getUserById(user_id);
        return CommonResult.success(user);
    }

    @GetMapping(value = "/findPage")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_MANAGER','ROLE_ADMIN')")
    @ApiOperation("获取所有用户的信息（分页）")
    public CommonResult<PageResult> getAllUser(@RequestBody PageRequest pageRequest) {
        PageResult pageResult = userService.findUserWithPage(pageRequest);
        return CommonResult.success(pageResult);
    }
}

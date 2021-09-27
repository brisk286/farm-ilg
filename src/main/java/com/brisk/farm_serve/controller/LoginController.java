package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.constants.SecurityConstants;
import com.brisk.farm_serve.pojo.bo.LoginRequest;
import com.brisk.farm_serve.pojo.bo.UserRegisterRequest;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.impl.AuthServiceImpl;
import com.brisk.farm_serve.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@Api(tags = "登录: Login")
public class LoginController {

    @Autowired
    public AuthServiceImpl authService;

    @Autowired
    public UserServiceImpl userService;

//    @PostMapping(value = "/test")
//    @ApiOperation(value = "测试")
//    public CommonResult<Object> test(@RequestBody LoginRequest loginRequest) {
//        String token = authService.test(loginRequest);
//        return CommonResult.success();
//    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "注册")
    public CommonResult<Object> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        userService.save(userRegisterRequest);
        return CommonResult.success();
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录")
    public CommonResult<HttpHeaders> login(@RequestBody LoginRequest loginRequest) {
        // 根据loginRequest创建token
        String token = authService.createToken(loginRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        // 将token的值放到http请求头中
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, token);
        return CommonResult.success(httpHeaders);
    }

    @PostMapping(value = "/logout")
    @ApiOperation(value = "退出")
    public CommonResult<Object> logout() {
        // 删除Redis中存储的token
        authService.removeToken();
        return CommonResult.success();
    }

}

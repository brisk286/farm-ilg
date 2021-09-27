package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.bo.LoginRequest;

public interface AuthService {

    public String createToken(LoginRequest loginRequest);

    public void removeToken();
}

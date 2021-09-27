package com.brisk.farm_serve.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {

    private String username;

    private String password;

    private Boolean rememberMe;

}

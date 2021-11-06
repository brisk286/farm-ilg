package com.brisk.farm_serve.pojo.bo;

import com.brisk.farm_serve.pojo.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String user_name;
    private String password;
    private String full_name;

    public User toUser() {
        return User.builder().full_name(this.getFull_name())
                .user_name(this.getUser_name())
                .enable(true).build();
    }
}


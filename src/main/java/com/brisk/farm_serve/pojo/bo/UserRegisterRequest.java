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
    private String password_confirm;
    private String phone_number;
    private String email;


    public User toUser() {
        return User.builder()
                .user_name(this.getUser_name())
                .phone_number(this.getPhone_number())
                .email(this.getEmail())
                .enable(true).build();
    }
}


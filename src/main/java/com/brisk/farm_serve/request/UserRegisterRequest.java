package com.brisk.farm_serve.request;

import com.brisk.farm_serve.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String userName;
    private String password;
    private String fullName;

    public User toUser() {
        return User.builder().full_name(this.getFullName())
                .user_name(this.getUserName())
                .enable(true).build();
    }
}


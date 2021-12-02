package com.brisk.farm_serve.pojo.po;

import com.brisk.farm_serve.pojo.bo.UserRepresentation;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    // 主键由数据库自动生成

    private Long user_id;

    private String user_name;

    private String password;

    private Long farm_id;

    private Boolean enable;

    private String phone_number;

    private String email;

    public UserRepresentation toUserRepresentation() {
        return UserRepresentation.builder()
                .userName(this.user_name).build();
    }

}

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

    private String full_name;

    private Boolean enable;


    public UserRepresentation toUserRepresentation() {
        return UserRepresentation.builder().fullName(this.full_name)
                .userName(this.user_name).build();
    }

}

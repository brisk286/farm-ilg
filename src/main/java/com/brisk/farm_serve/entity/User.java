package com.brisk.farm_serve.entity;

import com.brisk.farm_serve.mbg.mapper.RoleMapper;
import com.brisk.farm_serve.representation.UserRepresentation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

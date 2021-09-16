package com.brisk.farm_serve.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class User {

    @ApiModelProperty(value = "用户id")
    private Long user_id;

    @ApiModelProperty(value = "用户名")
    private String user_name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "使用的农场id")
    private Long farm_id;

    @ApiModelProperty(value = "角色")
    private String role;

}

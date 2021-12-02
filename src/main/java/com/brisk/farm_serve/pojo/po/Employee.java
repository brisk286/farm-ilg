package com.brisk.farm_serve.pojo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Employee {
    @ApiModelProperty(value = "人员id")
    private Long employee_id;

    @ApiModelProperty(value = "姓名")
    private String employee_name;

    @ApiModelProperty(value = "性别")
    private String employee_gender;

    @ApiModelProperty(value = "工号")
    private String employee_seq;

    @ApiModelProperty(value = "管理区域")
    private String employee_area;

    @ApiModelProperty(value = "在职状态")
    private String employee_state;
}

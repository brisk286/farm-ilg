package com.brisk.farm_serve.pojo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    @ApiModelProperty(value = "计划执行人")
    private String name;

    @ApiModelProperty(value = "计划内容")
    private String content;

}

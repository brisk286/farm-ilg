package com.brisk.farm_serve.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Opt {

    @ApiModelProperty(value = "操作id")
    private Long opt_id;

    @ApiModelProperty(value = "操作类型")
    private String opt_cls;

    @ApiModelProperty(value = "操作时间")
    private Timestamp opt_time;

    @ApiModelProperty(value = "操作地块")
    private Long area_id;
}

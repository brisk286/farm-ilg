package com.brisk.farm_serve.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Commit {

    @ApiModelProperty(value = "提交id")
    private Long commit_id;

    @ApiModelProperty(value = "设备id")
    private Long device_id;

    @ApiModelProperty(value = "数值")
    private int commit_value;

    @ApiModelProperty(value = "提交时间")
    private Timestamp commit_time;

}

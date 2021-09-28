package com.brisk.farm_serve.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
public class NextDayPlan {

    @ApiModelProperty(value = "计划开始时间")
    private Timestamp planTime;

    @ApiModelProperty(value = "计划名称")
    private String planName;

    @ApiModelProperty(value = "计划执行人")
    private String planExecutor;

    @ApiModelProperty(value = "计划执行地块")
    private Long planArea;
}

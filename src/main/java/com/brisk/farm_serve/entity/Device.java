package com.brisk.farm_serve.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Device {

    @ApiModelProperty(value = "设备id")
    private Long device_id;

    @ApiModelProperty(value = "名称")
    private String device_name;

    @ApiModelProperty(value = "所属系统")
    private String device_system;

    @ApiModelProperty(value = "当前检测数值")
    private int device_value;

    @ApiModelProperty(value = "最新更新时间")
    private Timestamp last_time;

    @ApiModelProperty(value = "投入使用时间")
    private Timestamp dur_time;

    @ApiModelProperty(value = "属于的地块")
    private Long area_id;

    @ApiModelProperty(value = "是否正在运行")
    private Boolean is_run;

    @ApiModelProperty(value = "是否损坏")
    private Boolean is_wrong;

    @ApiModelProperty(value = "序列号")
    private String ser_number;

    @ApiModelProperty(value = "电量")
    private int elec_value;

    @ApiModelProperty(value = "网络情况")
    private String net_condition;

}

package com.brisk.farm_serve.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Product {

    @ApiModelProperty(value = "农作物id")
    private Long product_id;

    @ApiModelProperty(value = "名称")
    private String product_name;

    @ApiModelProperty(value = "生产日期")
    private Timestamp birth_day;

    @ApiModelProperty(value = "所属地块")
    private Long area_id;

}

package com.brisk.farm_serve.pojo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Area {

    @ApiModelProperty(value = "地块id")
    private Long area_id;

    @ApiModelProperty(value = "农作物类型")
    private String product_cls;

    @ApiModelProperty(value = "属于的农场id")
    private Long farm_id;

}

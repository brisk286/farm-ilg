package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.pojo.po.Product;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
@Api(tags = "农产品: Product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

//    @GetMapping(value = "/{product_id}")
//    @ApiOperation(value = "查询农产品")
//    public CommonResult<Product> getProductById(@PathVariable(value = "product_id") Long product_id) {
//        Product product = productInfoService.getProductById(product_id);
//        return CommonResult.success(product);
//    }
//
//    @PostMapping
//    @ApiOperation(value = "添加农产品")
//    public CommonResult<Object> insertProduct(@RequestBody Product product){
//        productInfoService.insertProduct(product);
//        return CommonResult.success();
//    }
//
//    @DeleteMapping(value = "/{product_id}")
//    @ApiOperation(value = "删除农产品")
//    public CommonResult<Object> deleteProduct(@PathVariable(value = "product_id") Long product_id){
//        productInfoService.deleteProduct(product_id);
//        return CommonResult.success();
//    }
}

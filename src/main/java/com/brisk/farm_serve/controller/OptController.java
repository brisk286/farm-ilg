package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.pojo.dto.NextDayPlan;
import com.brisk.farm_serve.pojo.po.Opt;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.OptInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/opt")
@Api(tags = "操作: Opt")
public class OptController {

    @Autowired
    private OptInfoService optInfoService;

//    @GetMapping(value = "/{opt_id}")
//    @ApiOperation(value = "查询操作")
//    public CommonResult<Opt> getOptById(@PathVariable(value = "opt_id") Long opt_id){
//        Opt opt = optInfoService.getOptById(opt_id);
//        return CommonResult.success(opt);
//    }
//
//    @PostMapping(value = "/insert")
//    @ApiOperation(value = "添加操作")
//    public CommonResult<Object> insertOpt(@RequestBody Opt opt){
//        optInfoService.insertOpt(opt);
//        return CommonResult.success();
//    }
//
//    @DeleteMapping(value = "/{opt_id}")
//    @ApiOperation(value = "删除操作")
//    public CommonResult<Object> deleteOpt(@PathVariable(value = "opt_id") Long opt_id){
//        optInfoService.deleteOpt(opt_id);
//        return CommonResult.success();
//    }

//    @GetMapping(value = "/cls/{opt_cls}")
//    @ApiOperation(value = "查询属于特定类型的操作")
//    public CommonResult<Opt> getOptByCls(@PathVariable(value = "opt_cls") String opt_cls){
//        Opt opt = optInfoService.getOptByCls(opt_cls);
//        return CommonResult.success(opt);
//    }

    @GetMapping(value = "/plan")
    @ApiOperation(value = "查询未来一天的操作")
    public CommonResult<ArrayList<NextDayPlan>> getFuturePlan(){
        ArrayList<NextDayPlan> plans = optInfoService.getFuturePlan();
        return CommonResult.success(plans);
    }
}

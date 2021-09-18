package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.entity.Device;
import com.brisk.farm_serve.entity.Opt;
import com.brisk.farm_serve.entity.Plan;
import com.brisk.farm_serve.entity.User;
import com.brisk.farm_serve.mbg.mapper.DeviceMapper;
import com.brisk.farm_serve.mbg.mapper.OptMapper;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.OptInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/opt")
@Api(tags = "操作: Opt")
public class OptController {

    @Autowired
    private OptInfoService optInfoService;

    @GetMapping(value = "/{opt_id}")
    @ApiOperation(value = "查询操作")
    public CommonResult<Opt> getOptById(@PathVariable(value = "opt_id") Long opt_id){
        Opt opt = optInfoService.getOptById(opt_id);
        return CommonResult.success(opt);
    }

    @PostMapping
    @ApiOperation(value = "添加操作")
    public CommonResult<Object> insertOpt(@RequestBody Opt opt){
        optInfoService.insertOpt(opt);
        return CommonResult.success();
    }

    @DeleteMapping(value = "/{opt_id}")
    @ApiOperation(value = "删除操作")
    public CommonResult<Object> deleteOpt(@PathVariable(value = "opt_id") Long opt_id){
        optInfoService.deleteOpt(opt_id);
        return CommonResult.success();
    }

    @GetMapping(value = "/cls/{opt_cls}")
    @ApiOperation(value = "查询属于特定类型的操作")
    public CommonResult<Opt> getOptByCls(@PathVariable(value = "opt_cls") String opt_cls){
        Opt opt = optInfoService.getOptByCls(opt_cls);
        return CommonResult.success(opt);
    }

    @GetMapping(value = "/plan")
    @ApiOperation(value = "查询未来计划的操作")
    public CommonResult<ArrayList<Plan>> getFuturePlan(){
        ArrayList<Plan> plans = optInfoService.getFuturePlan();
        return CommonResult.success(plans);
    }
}

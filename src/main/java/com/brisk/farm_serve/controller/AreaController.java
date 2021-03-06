package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.pojo.po.Area;
import com.brisk.farm_serve.pojo.po.Device;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.AreaInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/area")
@Api(tags = "地块: Area")
public class AreaController {

    @Autowired
    private AreaInfoService areaInfoService;

//    @GetMapping(value = "/{area_id}")
//    @ApiOperation(value = "查询地块")
//    public CommonResult<Area> getAreaById(@PathVariable(value = "area_id") Long area_id){
//        Area area = areaInfoService.getAreaById(area_id);
//        return CommonResult.success(area);
//    }
//
//    @PostMapping
//    @ApiOperation(value = "添加地块")
//    public CommonResult<Object> insertArea(@RequestBody Area area){
//        areaInfoService.insertArea(area);
//        return CommonResult.success();
//    }
//
//    @DeleteMapping(value = "/{area_id}")
//    @ApiOperation(value = "删除地块")
//    public CommonResult<Object> deleteArea(@PathVariable(value = "area_id") Long area_id){
//        areaInfoService.deleteArea(area_id);
//        return CommonResult.success();
//    }

    @GetMapping(value = "/userOwn")
    @ApiOperation(value = "查询用户拥有的地块")
    public CommonResult<ArrayList<Area>> getAreaByUserId(){
        ArrayList<Area> areas = areaInfoService.getAreaByUserId();
        return CommonResult.success(areas);
    }

    @GetMapping(value = "/wrongDevice")
    @ApiOperation(value = "查询用户的地块中损坏的设备")
    public CommonResult<ArrayList<Device>> getWrongDeviceNumByUserId(){
        ArrayList<Device> devices = areaInfoService.getWrongDeviceByUserId();
        return CommonResult.success(devices);
    }

    @GetMapping(value = "/runDevice")
    @ApiOperation(value = "查询用户拥有的地块中正在运行的设备")
    public CommonResult<ArrayList<Device>> getRunDeviceNumByAreaId(){
        ArrayList<Device> devices = areaInfoService.getRunDeviceByUserId();
        return CommonResult.success(devices);
    }

    @GetMapping(value = "/runDevice/{area_id}")
    @ApiOperation(value = "查询用户拥有的某个地块中正在运行的设备")
    public CommonResult<ArrayList<Device>> getRunDeviceNumByUserId(@PathVariable(value = "area_id") Long area_id){
        ArrayList<Device> devices = areaInfoService.getRunDeviceNumByAreaId(area_id);
        return CommonResult.success(devices);
    }

    @GetMapping(value = "cls/{area_cls}")
    @ApiOperation(value = "查询属于特定分类的地块")
    public CommonResult<ArrayList<Area>> getAreaByCls(@PathVariable(value = "area_cls") String area_cls){
        ArrayList<Area> areas = areaInfoService.getAreaByCls(area_cls);
        return CommonResult.success(areas);
    }

    @GetMapping(value = "/farm/{farm_id}")
    @ApiOperation(value = "查询不同区域地块")
    public CommonResult<ArrayList<Area>> getAreaByFarmId(@PathVariable(value = "farm_id") Long farm_id){
        ArrayList<Area> areas = areaInfoService.getAreaByFarmId(farm_id);
        return CommonResult.success(areas);
    }
}

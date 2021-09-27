package com.brisk.farm_serve.controller;

import com.brisk.farm_serve.pojo.po.Device;
import com.brisk.farm_serve.result.CommonResult;
import com.brisk.farm_serve.service.DeviceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/device")
@Api(tags = "设备: Device")
public class DeviceController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @GetMapping(value = "/{device_id}")
    @ApiOperation(value = "查询设备")
    public CommonResult<Device> getDeviceById(@PathVariable(value = "device_id") Long divice_id){
        Device device = deviceInfoService.getDeviceById(divice_id);
        return CommonResult.success(device);
    }

    @PostMapping
    @ApiOperation(value = "添加设备")
    public CommonResult<Object> insertDevice(@RequestBody Device device){
        deviceInfoService.insertDevice(device);
        return CommonResult.success();
    }

    @DeleteMapping(value = "/{device_id}")
    @ApiOperation(value = "删除设备")
    public CommonResult<Object> deleteDevice(@PathVariable(value = "device_id") Long device_id){
        deviceInfoService.deleteDevice(device_id);
        return CommonResult.success();
    }
}

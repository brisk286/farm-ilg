package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.entity.Device;
import com.brisk.farm_serve.mbg.mapper.DeviceMapper;
import com.brisk.farm_serve.service.DeviceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    DeviceMapper deviceMapper;

    @Override
    public Device getDeviceById(Long device_id) {
        return null;
    }

    @Override
    public void insertDevice(Device device) {

    }

    @Override
    public void deleteDevice(Long device_id) {

    }
}

package com.brisk.farm_serve.service;

import com.brisk.farm_serve.entity.Device;
import com.brisk.farm_serve.mbg.mapper.DeviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface DeviceInfoService {

    Device getDeviceById(Long device_id);

    void insertDevice(Device device);

    void deleteDevice(Long device_id);
}

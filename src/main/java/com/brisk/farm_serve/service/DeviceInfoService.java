package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.po.Device;

public interface DeviceInfoService {

    Device getDeviceById(Long device_id);

    void insertDevice(Device device);

    void deleteDevice(Long device_id);
}

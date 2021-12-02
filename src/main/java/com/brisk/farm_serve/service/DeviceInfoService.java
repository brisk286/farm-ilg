package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.po.Device;

import java.util.ArrayList;

public interface DeviceInfoService {

    Device getDeviceById(Long device_id);

    void insertDevice(Device device);

    void deleteDevice(Long device_id);

    ArrayList<Device> getDeviceByAreaId(Long area_id);

    void updateDevice(Device device);
}

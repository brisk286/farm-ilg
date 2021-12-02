package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.po.Device;
import com.brisk.farm_serve.mbg.mapper.DeviceMapper;
import com.brisk.farm_serve.service.DeviceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Resource
    DeviceMapper deviceMapper;

    @Override
    public Device getDeviceById(Long device_id) {
        return deviceMapper.getDeviceById(device_id);
    }

    @Override
    public void insertDevice(Device device) {
        deviceMapper.insertDevice(device);
    }

    @Override
    public void deleteDevice(Long device_id) {
        deviceMapper.deleteDevice(device_id);
    }

    @Override
    public ArrayList<Device> getDeviceByAreaId(Long area_id) {
        return deviceMapper.getDeviceByAreaId(area_id);
    }

    @Override
    public void updateDevice(Device device) {
        deviceMapper.updateDevice(device);
    }
}

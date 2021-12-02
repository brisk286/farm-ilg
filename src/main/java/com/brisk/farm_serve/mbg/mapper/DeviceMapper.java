package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.Device;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface DeviceMapper {

    Device getDeviceById(@Param("device_id") Long device_id);

    void insertDevice(@Param("device") Device device);

    void deleteDevice(@Param("device_id") Long device_id);

    ArrayList<Device> getDeviceByAreaId(@Param("area_id") Long area_id);

    void updateDevice(@Param("device") Device device);
}

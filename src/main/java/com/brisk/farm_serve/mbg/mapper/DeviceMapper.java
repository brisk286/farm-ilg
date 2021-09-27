package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.Device;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {

    Device getDeviceById(@Param("device_id") Long device_id);

    void insertDevice(@Param("device") Device device);

    void deleteDevice(@Param("divice_id") Long device_id);
}

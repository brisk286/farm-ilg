package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.Area;
import com.brisk.farm_serve.entity.Device;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AreaMapper {

    Area getAreaById(@Param("area_id") Long area_id);

    ArrayList<Area> getAreaByUserId(@Param("user_id") Long user_id);

    ArrayList<Device> getWrongDeviceByUser(@Param("user_id") Long user_id);

    ArrayList<Device> getRunDeviceByUser(@Param("user_id") Long user_id);

    ArrayList<Area> getAreaByCls(@Param("area_cls") String area_cls);

    ArrayList<Area> getAreaByFarmId(@Param("farm_id") Long farm_id);

    void insertArea(@Param("area") Area area);

    void deleteArea(@Param("user_id") Long user_id);
}

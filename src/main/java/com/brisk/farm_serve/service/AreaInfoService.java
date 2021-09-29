package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.po.Area;
import com.brisk.farm_serve.pojo.po.Device;

import java.util.ArrayList;

public interface AreaInfoService {

    Area getAreaById(Long area_id);

    void insertArea(Area area);

    void deleteArea(Long area_id);

    ArrayList<Area> getAreaByUserId();

    ArrayList<Device> getWrongDeviceByUserId();

    ArrayList<Device> getRunDeviceByUserId();

    ArrayList<Area> getAreaByCls(String area_cls);

    ArrayList<Area> getAreaByFarmId(Long farm_id);
}

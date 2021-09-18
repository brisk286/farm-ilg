package com.brisk.farm_serve.service;

import com.brisk.farm_serve.entity.Area;
import com.brisk.farm_serve.entity.Device;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public interface AreaInfoService {

    Area getAreaById(Long area_id);

    void insertArea(Area area);

    void deleteArea(Long area_id);

    ArrayList<Area> getAreaByUserId(Long user_id);

    ArrayList<Device> getWrongDeviceByUser(Long user_id);

    ArrayList<Device> getRunDeviceByUser(Long user_id);

    ArrayList<Area> getAreaByCls(String area_cls);

    ArrayList<Area> getAreaByFarmId(Long farm_id);
}

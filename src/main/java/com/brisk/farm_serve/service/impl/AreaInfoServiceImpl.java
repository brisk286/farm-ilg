package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.po.Area;
import com.brisk.farm_serve.pojo.po.Device;
import com.brisk.farm_serve.mbg.mapper.AreaMapper;
import com.brisk.farm_serve.service.AreaInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class AreaInfoServiceImpl implements AreaInfoService {

    @Resource
    AreaMapper areaMapper;

    @Override
    public Area getAreaById(Long area_id) {
        return areaMapper.getAreaById(area_id);
    }

    @Override
    public void insertArea(Area area) {

    }

    @Override
    public void deleteArea(Long area_id) {

    }

    @Override
    public ArrayList<Area> getAreaByUserId(Long user_id) {
        return areaMapper.getAreaByUserId(user_id);
    }

    @Override
    public ArrayList<Device> getWrongDeviceByUser(Long user_id) {
        return areaMapper.getWrongDeviceByUser(user_id);
    }

    @Override
    public ArrayList<Device> getRunDeviceByUser(Long user_id) {
        return areaMapper.getRunDeviceByUser(user_id);
    }

    @Override
    public ArrayList<Area> getAreaByCls(String area_cls) {
        return areaMapper.getAreaByCls(area_cls);
    }

    @Override
    public ArrayList<Area> getAreaByFarmId(Long farm_id) {
        return areaMapper.getAreaByFarmId(farm_id);
    }
}

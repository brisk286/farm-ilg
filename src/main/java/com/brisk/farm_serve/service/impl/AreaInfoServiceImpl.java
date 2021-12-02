package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.po.Area;
import com.brisk.farm_serve.pojo.po.Device;
import com.brisk.farm_serve.mbg.mapper.AreaMapper;
import com.brisk.farm_serve.service.AreaInfoService;
import com.brisk.farm_serve.util.CurrentUserUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaInfoServiceImpl implements AreaInfoService {

    @Resource
    AreaMapper areaMapper;

    @Resource
    CurrentUserUtils currentUserUtils;

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
    public ArrayList<Area> getAreaByUserId() {
        return areaMapper.getAreaByUserId(currentUserUtils.getCurrentUser().getUser_id());
    }

    @Override
    public ArrayList<Device> getWrongDeviceByUserId() {
        return areaMapper.getWrongDeviceByUserId(currentUserUtils.getCurrentUser().getUser_id());
    }

    @Override
    public ArrayList<Device> getRunDeviceByUserId() {
        return areaMapper.getRunDeviceByUserId(currentUserUtils.getCurrentUser().getUser_id());
    }

    @Override
    public ArrayList<Device> getRunDeviceNumByAreaId(Long area_id) {
        ArrayList<Device> devices = getRunDeviceByUserId();
        for(int i = 0; i < devices.size(); ++i) {
            if(devices.get(i).getArea_id() != area_id) {
                devices.remove(i);
            }
        }
        return devices;
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

package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.dto.NextDayPlan;
import com.brisk.farm_serve.pojo.po.Opt;
import com.brisk.farm_serve.mbg.mapper.OptMapper;
import com.brisk.farm_serve.service.OptInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class OptInfoServiceImpl implements OptInfoService {

    @Resource
    OptMapper optMapper;

    @Override
    public Opt getOptById(Long opt_id) {
        return null;
    }

    @Override
    public void insertOpt(Opt opt) {
        optMapper.insertOpt(opt);
    }

    @Override
    public void deleteOpt(Long opt_id) {

    }

    @Override
    public Opt getOptByCls(String opt_cls) {
        return null;
    }

    @Override
    public ArrayList<NextDayPlan> getFuturePlan() {
        Timestamp currentTime = new Timestamp((System.currentTimeMillis()));
        Timestamp nextDayTime = new Timestamp((System.currentTimeMillis()) + 24*60*60*1000);
        return optMapper.getFuturePlan(currentTime.toString(), nextDayTime.toString());
    }
}

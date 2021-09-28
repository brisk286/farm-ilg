package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.dto.NextDayPlan;
import com.brisk.farm_serve.pojo.po.Opt;

import java.util.ArrayList;


public interface OptInfoService{

    Opt getOptById(Long opt_id);

    void insertOpt(Opt opt);

    void deleteOpt(Long opt_id);

    Opt getOptByCls(String opt_cls);

    ArrayList<NextDayPlan> getFuturePlan();
}

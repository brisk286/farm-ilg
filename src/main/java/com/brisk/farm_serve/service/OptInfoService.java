package com.brisk.farm_serve.service;

import com.brisk.farm_serve.pojo.po.Opt;
import com.brisk.farm_serve.pojo.po.Plan;

import java.util.ArrayList;


public interface OptInfoService{

    Opt getOptById(Long opt_id);

    void insertOpt(Opt opt);

    void deleteOpt(Long opt_id);

    Opt getOptByCls(String opt_cls);

    ArrayList<Plan> getFuturePlan();
}

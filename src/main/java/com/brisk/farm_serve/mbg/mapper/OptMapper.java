package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.po.Opt;
import com.brisk.farm_serve.pojo.po.Plan;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface OptMapper {

    Opt getOptById(@Param("opt_id") Long opt_id);

    Opt getOptByCls(@Param("opt_cls") String opt_cls);

    void insertOpt(@Param("opt") Opt opt);

    void deleteOpt(@Param("opt_id") Long opt_id);

//    ArrayList<Opt> getFuturePlan(@Param("cur_time") Timestamp cur_time);
    ArrayList<Plan> getFuturePlan();

}

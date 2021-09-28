package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.pojo.dto.NextDayPlan;
import com.brisk.farm_serve.pojo.po.Opt;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface OptMapper {

    Opt getOptById(@Param("opt_id") Long opt_id);

    Opt getOptByCls(@Param("opt_cls") String opt_cls);

    void insertOpt(@Param("opt") Opt opt);

    void deleteOpt(@Param("opt_id") Long opt_id);

//    ArrayList<NextDayPlan> getFuturePlan(@Param("currentTime") String currentTime, @Param("nextDayTime") String nextDayTime);
    ArrayList<NextDayPlan> getFuturePlan(@Param("currentTime") String currentTime, @Param("nextDayTime") String nextDayTime);

}

package com.brisk.farm_serve.mbg.mapper;

import com.brisk.farm_serve.entity.Area;
import com.brisk.farm_serve.entity.Opt;
import com.brisk.farm_serve.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface OptMapper {

    Opt getOptById(@Param("opt_id") Long opt_id);

    Opt getOptByCls(@Param("opt_cls") String opt_cls);

    void insertOpt(@Param("opt") Opt opt);

    void deleteOpt(@Param("opt_id") Long opt_id);
}

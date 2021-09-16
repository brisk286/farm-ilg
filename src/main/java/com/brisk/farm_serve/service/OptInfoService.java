package com.brisk.farm_serve.service;

import com.brisk.farm_serve.entity.Opt;
import org.springframework.stereotype.Service;


public interface OptInfoService{

    Opt getOptById(Long opt_id);

    void insertOpt(Opt opt);

    void deleteOpt(Long opt_id);

    Opt getOptByCls(String opt_cls);
}

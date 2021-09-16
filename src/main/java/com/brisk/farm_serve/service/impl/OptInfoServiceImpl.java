package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.entity.Opt;
import com.brisk.farm_serve.service.OptInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OptInfoServiceImpl implements OptInfoService {

    @Resource
    OptInfoService optInfoService;

    @Override
    public Opt getOptById(Long opt_id) {
        return null;
    }

    @Override
    public void insertOpt(Opt opt) {

    }

    @Override
    public void deleteOpt(Long opt_id) {

    }

    @Override
    public Opt getOptByCls(String opt_cls) {
        return null;
    }
}

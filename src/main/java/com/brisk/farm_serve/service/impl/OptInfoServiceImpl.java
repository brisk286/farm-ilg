package com.brisk.farm_serve.service.impl;

import com.brisk.farm_serve.pojo.po.Opt;
import com.brisk.farm_serve.pojo.po.Plan;
import com.brisk.farm_serve.mbg.mapper.OptMapper;
import com.brisk.farm_serve.service.OptInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    }

    @Override
    public void deleteOpt(Long opt_id) {

    }

    @Override
    public Opt getOptByCls(String opt_cls) {
        return null;
    }

    @Override
    public ArrayList<Plan> getFuturePlan() {
//        Long datetime = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(datetime);
//        ArrayList<Opt> opts = optMapper.getFuturePlan();
//        ArrayList<Plan> plans = new ArrayList<>();
//        Iterator<Opt> it = opts.iterator();
//
//        while(it.hasNext()) {
//            Opt opt = it.next();
//            Plan plan = new Plan(opt.getOpt_excter().toString(), "计划编号：" + opt.getOpt_id() + " 操作：" + opt.getOpt_cls() + " 时间：" +
//                    opt.getOpt_time() + " 负责地块：" + opt.getArea_id());
//            plan.setName(opt.getOpt_excter().toString());
//            plan.setContent("计划编号：" + opt.getOpt_id() + " 操作：" + opt.getOpt_cls() + " 时间：" +
//                            opt.getOpt_time() + " 负责地块：" + opt.getArea_id());
//            plans.add(plan);
//        }

//        return plans;
        return optMapper.getFuturePlan();
    }
}

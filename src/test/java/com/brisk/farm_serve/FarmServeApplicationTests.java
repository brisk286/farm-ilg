package com.brisk.farm_serve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class FarmServeApplicationTests {

    @Test
    void contextLoads() {
//        Date date = new Date(System.currentTimeMillis());
//        Date nu = new Date();
//        System.out.println(date);
//        System.out.println(nu.getTime());
        Timestamp d = new Timestamp(System.currentTimeMillis() + 24*60*60*1000);
        System.out.println(d.toString());
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
//        System.out.println(sdf.format(new Date())); // 输出已经格式化的现在时间（24小时制）
    }


}

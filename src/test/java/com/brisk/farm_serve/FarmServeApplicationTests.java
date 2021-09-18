package com.brisk.farm_serve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SpringBootTest
class FarmServeApplicationTests {

    @Test
    void contextLoads() {
        Long datetime = System.currentTimeMillis();
        System.out.println(datetime);
        Timestamp timestamp = new Timestamp(datetime);
        System.out.println(timestamp);
        System.out.println(timestamp);
    }

}

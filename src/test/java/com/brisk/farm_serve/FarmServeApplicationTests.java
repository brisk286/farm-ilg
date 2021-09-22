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
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }

}

package com.brisk.farm_serve.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置
 */
@Configuration
@MapperScan("com.brisk.farm_serve.mbg.mapper")
public class MyBatisConfig {
}

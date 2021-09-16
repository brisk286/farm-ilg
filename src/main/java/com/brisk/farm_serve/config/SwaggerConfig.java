package com.brisk.farm_serve.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private Boolean enabled;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                // 是否开启swagger
                .enable(enabled)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径
                // 错误error路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("接口文档111")
                // 接口描述
                .description("云上稻香智慧农业管理平台——brisk")
                // 版本信息
                .version("1.0")
                // 构建
                .build();
    }
}

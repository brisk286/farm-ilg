package com.brisk.farm_serve.aspect;


import com.brisk.farm_serve.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * controller层日志
 * @author clf
 */
@Aspect
@Slf4j
@Component
public class ControllerLog {

    // 匹配com.brisk.farm_serve.controller中所有公有方法
    @Pointcut("execution(public * com.brisk.farm_serve.controller.*.*(..))")
    // Point签名
    public void controller(){
    }

    @Before("controller()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        // com.brisk.farm_serve.controller + '.' + OptController.getFuturePlan
        String method = signature.getDeclaringTypeName()+"."+signature.getName();
        log.info("-----------------------------------------------------");
        log.info("当前执行controller的方法:  "+method);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("参数: "+ arg);
        }
    }

    @AfterReturning(pointcut = "controller()",returning = "ret")
    public void after(Object ret){
        CommonResult result = (CommonResult) ret;
        if (result!=null&&result.getCode()!=0){
            log.info(result.getMessage());
        }
        log.info("controller返回参数："+result);
        log.info("-----------------------------------------------------");
    }
}


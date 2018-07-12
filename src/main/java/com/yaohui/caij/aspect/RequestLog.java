package com.yaohui.caij.aspect;

import com.alibaba.fastjson.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class RequestLog {

    public static final Logger logger = LoggerFactory.getLogger(RequestLog.class);

    /**
     * Define a pointcut
     */
//    @Pointcut("execution(* com.wqxia.*.*(..))")
    @Pointcut("execution(* com.yaohui.*.controller.*Controller.*(..))")
    public void controllerLog() {
    }

    /**
     * Print Log before controller
     */
    @Before("controllerLog()")
    public void before(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        logger.info("请求IP：{}", request.getRemoteAddr());
        logger.info("请求路径：{}", request.getRequestURL());
        logger.info("请求方式：{}", request.getMethod());
        logger.info("请求参数：{}", JSONObject.toJSONString(request.getParameterMap()));

    }

    /**
     * Print the time that request method execution spend
     */
    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object retVal = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        logger.info("执行时间：{} ms", endTime - startTime);
        logger.info("返回值：{}\n\t", JSONObject.toJSONString(retVal));
        return retVal;
    }

    /**
     * Print exception
     */
    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void afterThrowing(Throwable ex) {
        logger.error("发生异常：{}", ex);
    }
}
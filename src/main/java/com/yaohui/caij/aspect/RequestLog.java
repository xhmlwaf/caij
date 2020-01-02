package com.yaohui.caij.aspect;

import com.alibaba.fastjson.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class RequestLog {
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

    log.info("请求IP：{}", request.getRemoteAddr());
    log.info("请求路径：{}", request.getRequestURL());
    log.info("请求方式：{}", request.getMethod());
    log.info("请求参数：{}", JSONObject.toJSONString(request.getParameterMap()));

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
    log.info("执行时间：{} ms", endTime - startTime);
    log.info("返回值：{}", JSONObject.toJSONString(retVal));
    return retVal;
  }

  /**
   * Print exception
   */
  @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
  public void afterThrowing(Throwable ex) {
    log.error("发生异常：{}", ex);
  }
}
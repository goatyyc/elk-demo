package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/19 17:11
 */
@Slf4j
@Aspect
@Component
public class ReqRspLog {

    /**
     * 定义一个公共切点，代码复用
     * 拦截com.quantacenter.controller.类下面的所有public方法
     */
    @Pointcut(value = "execution(public * com.example.demo.controller.*.*(..))")
    private void apiLog() {

    }

    /**
     * 方法执行前注入
     * @param joinPoint
     */
    @Before(value = "apiLog()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //获取用户访问的url
        log.info("url:{}",request.getRequestURL());
        // 获取用户访问的方式，get/post
        log.info("method={}", request.getMethod());
        // 获取的ip
        log.info("ip={}", request.getRemoteAddr());
        // 获取用户访问的是哪个方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 获取方法的参数
        log.info("args={}", joinPoint.getArgs());

    }
}

//package com.example.demo.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
//@Slf4j
//@Component
//@Aspect
//public class WebLog {
//
//    ThreadLocal<Long> startTime = new ThreadLocal<>();
//    ThreadLocal<String> requestTl = new ThreadLocal<>();
//
//    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
//    public void webLog(){
//
//    }
//
//    @Before("webLog()")
//    public void before(JoinPoint joinPoint){
//        startTime.set(System.currentTimeMillis());
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
////        HttpServletRequest request = attributes.getRequest();
////        log.info("URL: " + request.getRequestURL());
////        log.info("HTTP_METHOD: " + request.getMethod());
////        log.info("IP: " + request.getRemoteAddr());
////        log.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        log.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
//        requestTl.set("URL: " + request.getRequestURL() + "  " + "CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
//        + "  ARGS: " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(pointcut = "webLog()", returning = "ret")
//    public void after(Object ret){
//        try {
////            log.info("request: " + requestTl.get() + "\n response" + ret + "  " + "总共耗时: " + (System.currentTimeMillis() - startTime.get()));
////            throw new RuntimeException("xxx");
//        } finally {
//            startTime.remove();
//            requestTl.remove();
//        }
//    }
//
//
//
//
//}

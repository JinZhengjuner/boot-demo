//package com.example.demo.intercepter;
//
//import com.example.demo.pojo.Student;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Optional;
//
//
//@Component
//@Slf4j
//public class CommonInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        log.info("进入到拦截器中:preHandle() 方法");
////        System.out.println(request.getServletPath());
//
//        return true;
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
////        log.info("进入到拦截器中:postHandle() 方法中");
////        System.out.println(request.getRequestURI());
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
////        log.info("进入到拦截器中:afterCompletion() 方法中");
////        System.out.println(request.getServletPath());
//    }
//
//    public static void main(String[] args) {
//        Student student = new Student();
//        String xxx = Optional.ofNullable(student).map(Student::getName).orElse(null)+"aaa";
//        System.out.println(xxx);
//
//
//    }
//
//}

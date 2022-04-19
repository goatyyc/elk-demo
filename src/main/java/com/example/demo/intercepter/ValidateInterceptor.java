//package com.example.demo.intercepter;
//
//import com.example.demo.annotation.NonNull;
//import org.aopalliance.intercept.Interceptor;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Field;
//import java.lang.reflect.Parameter;
//
///**
// * @description:
// * @author: yyc
// * @time: 2022/3/31 13:10
// */
//public class ValidateInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        // 获取参数列表
//        Parameter[] parameters = handlerMethod.getMethod().getParameters();
//        for (Parameter parameter : parameters) {
//            // 获取参数字段
//            Field[] fields = parameter.getType().getDeclaredFields();
//            for (Field field : fields) {
//                NonNull annotation = field.getAnnotation(NonNull.class);
//                // 如果该字段有NonNull注解
//                if(annotation!=null){
//                    field.setAccessible(true);
//                    String s = field.get(getTargetObject(parameter, request)).toString();
//                    if(s==null){
//                        // 封装信息返回给前端,可以定义全局异常捕获
//                        throw new RuntimeException(field.getName()+": 不能为空");
//                    }
//                }
//            }
//        }
//
//    }
//
//    /**
//     * 从HttpServletRequest拿到字节流，进而去获取目标对象
//     * @param parameter
//     * @param request
//     * @return
//     */
//    private Object getTargetObject(Parameter parameter, HttpServletRequest request) {
//        Class<?> type = parameter.getType();
////        request.get
//    }
//}

package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonNull {
    
}

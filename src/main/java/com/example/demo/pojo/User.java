package com.example.demo.pojo;

import com.example.demo.annotation.NonNull;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: yyc
 * @time: 2022/3/31 13:04
 */
@Data
public class User {
    
    @NotNull
    private String username;
    
    @Min(0)
    private Integer age;

}

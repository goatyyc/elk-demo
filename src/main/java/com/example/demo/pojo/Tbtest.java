package com.example.demo.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * tbtest
 * @author 
 */
@Data
public class Tbtest implements Serializable {
    private Integer id;

    private Integer type;

    private String name;

    private Long money;

    private static final long serialVersionUID = 1L;
}
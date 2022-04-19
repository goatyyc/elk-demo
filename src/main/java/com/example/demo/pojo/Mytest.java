package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mytest
 * @author 
 */
@Data
public class Mytest implements Serializable {
    private Integer id;

    private Date date;

    private Integer type;

    private Long money;

    private static final long serialVersionUID = 1L;
}
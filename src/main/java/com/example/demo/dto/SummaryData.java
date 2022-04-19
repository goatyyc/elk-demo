package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/2 14:32
 */
@Data
public class SummaryData {
    private String name;
    private BigDecimal total;
    private transient String titleValue;
    
    public void setTitleValue(String titleValue){
        if(titleValue!=null){
            typeValues = new ArrayList<String>(Arrays.asList(titleValue.split(",")));
        }
    }
    public List<String> typeValues = new ArrayList<>();
}

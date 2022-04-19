package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/1 20:36
 */
@Data
public class RowData {
    private String name;
    private BigDecimal total;
    private List<String> valueList;
}

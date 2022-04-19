package com.example.demo.mapper;

import com.example.demo.dto.RowData;
import com.example.demo.dto.SummaryData;
import com.example.demo.pojo.Tbtest;

import java.util.List;

public interface TbtestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tbtest record);

    int insertSelective(Tbtest record);

    Tbtest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tbtest record);

    int updateByPrimaryKey(Tbtest record);

    List<RowData> selectRowData();
    
    String selectByType(String name);
    
    List<SummaryData> selectSummaryData();
}
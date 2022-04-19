package com.example.demo.service;

import com.example.demo.dto.RowData;
import com.example.demo.dto.SummaryData;

import java.util.List;

public interface ITbTestService {
    public void test();
    public List<RowData> selectRowData();
    
    public List<SummaryData> selectSummaryData();
}

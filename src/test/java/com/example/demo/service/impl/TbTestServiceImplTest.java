package com.example.demo.service.impl;

import com.example.demo.dto.RowData;
import com.example.demo.dto.SummaryData;
import com.example.demo.service.ITbTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class TbTestServiceImplTest {
    @Autowired
    private ITbTestService tbTestService;
    
    @Test
    public void test(){
        List<RowData> rowData = tbTestService.selectRowData();
        for (RowData data : rowData) {
            log.info("data:{}",data);
        }
    }
    
    @Test
    public void test2(){
        List<SummaryData> summaryData = tbTestService.selectSummaryData();
        for (SummaryData data : summaryData) {
            log.info("data:{}",data);
        }
    }
}
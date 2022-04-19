package com.example.demo.service.impl;

import com.example.demo.dto.RowData;
import com.example.demo.dto.SummaryData;
import com.example.demo.mapper.TbtestMapper;
import com.example.demo.pojo.Tbtest;
import com.example.demo.service.ITbTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/1 20:30
 */
@Slf4j
@Service
public class TbTestServiceImpl implements ITbTestService {
    @Autowired
    private TbtestMapper tbtestMapper;
    
    @Override
    public void test() {
        Tbtest tbtest = tbtestMapper.selectByPrimaryKey(1);
        log.info("data {}",tbtest);
    }

    @Override
    public List<RowData> selectRowData() {
        return tbtestMapper.selectRowData();
    }

    @Override
    public List<SummaryData> selectSummaryData() {
        return tbtestMapper.selectSummaryData();
    }
}

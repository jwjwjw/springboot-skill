package com.jw.charttest.service;

import com.jw.charttest.model.DailyTxnAmtDetailDto;
import com.jw.charttest.model.DailyTxnAmtDto;
import com.jw.charttest.model.PieCharRecordDto;

import java.util.List;

public interface ChartService {
    List<PieCharRecordDto> getPieChartTestData();

    List<DailyTxnAmtDto> getBarChartTestData();

    List<DailyTxnAmtDetailDto> getStackedBarChartTestData();
}

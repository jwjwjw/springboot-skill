package com.jw.charttest.handler;

import org.springframework.http.ResponseEntity;

public interface ChartHandler {
    ResponseEntity genPieChart();

    ResponseEntity genBarChart();

    ResponseEntity genStackedBarChart();

}

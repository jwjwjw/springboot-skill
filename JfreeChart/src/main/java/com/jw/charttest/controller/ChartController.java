package com.jw.charttest.controller;


import com.jw.charttest.handler.ChartHandler;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/chart", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ChartController {

    private static final Logger logger = LoggerFactory.getLogger(ChartController.class);

    @Autowired
    ChartHandler chartHandler;

    @GetMapping("/pieChart")
    public ResponseEntity pieChartTest(){
        logger.debug("piechart start");
        ResponseEntity responseEntity = chartHandler.genPieChart();
        logger.debug("pie chart end");
        return responseEntity;
    }

    @GetMapping("/barChart")
    public ResponseEntity barChartTest(){
        logger.debug("barchart start");
        ResponseEntity responseEntity = chartHandler.genBarChart();
        logger.debug("bar chart end");
        return responseEntity;
    }

    @GetMapping("/stackedBarChart")
    public ResponseEntity stackedBarChartTest(){
        logger.debug("barchart start");
        ResponseEntity responseEntity = chartHandler.genStackedBarChart();
        logger.debug("bar chart end");
        return responseEntity;
    }

}

package com.jw.charttest.handler;


import com.jw.charttest.model.DailyTxnAmtDetailDto;
import com.jw.charttest.model.DailyTxnAmtDto;
import com.jw.charttest.model.PieCharRecordDto;
import com.jw.charttest.service.ChartService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Component
public class ChartHandlerImpl implements ChartHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChartHandlerImpl.class);

    @Autowired
    ChartService chartService;

    @Override
    public ResponseEntity genPieChart() {

        List<PieCharRecordDto> pieCharDataDto = chartService.getPieChartTestData();
        JFreeChart chart = genPieChart(pieCharDataDto);

        ResponseEntity<byte[]> respEntity = null;

        try {
            File file = File.createTempFile("piechart_"+UUID.randomUUID()+"_",".png");
            OutputStream os = new FileOutputStream(file);
            ChartUtilities.writeChartAsPNG(os,
                    chart,400,300,null);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.IMAGE_PNG);
            responseHeaders.setContentLength(Files.readAllBytes(file.toPath()).length);
            respEntity = new ResponseEntity<>(Files.readAllBytes(file.toPath()), responseHeaders, HttpStatus.OK);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return respEntity;
    }

    @Override
    public ResponseEntity genBarChart() {
        List<DailyTxnAmtDto> dailyTxnAmtDtos = chartService.getBarChartTestData();
        JFreeChart chart = genBarChart(dailyTxnAmtDtos);

        ResponseEntity<byte[]> respEntity = null;
        try {
            File file = File.createTempFile("barchart_"+UUID.randomUUID()+"_",".png");
            OutputStream os = new FileOutputStream(file);
            ChartUtilities.writeChartAsPNG(os, chart,400,300,null);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.IMAGE_PNG);
            responseHeaders.setContentLength(Files.readAllBytes(file.toPath()).length);
            respEntity = new ResponseEntity<>(Files.readAllBytes(file.toPath()), responseHeaders, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respEntity;
    }

    @Override
    public ResponseEntity genStackedBarChart() {
        List<DailyTxnAmtDetailDto> recordsDto = chartService.getStackedBarChartTestData();
        JFreeChart chart = genStackedBarChart(recordsDto);
        ResponseEntity<byte[]> respEntity = null;
        try {
            File file = File.createTempFile("stackedBarchart_"+UUID.randomUUID()+"_",".png");
            OutputStream os = new FileOutputStream(file);
            ChartUtilities.writeChartAsPNG(os, chart,400,300,null);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.IMAGE_PNG);
            responseHeaders.setContentLength(Files.readAllBytes(file.toPath()).length);
            respEntity = new ResponseEntity<>(Files.readAllBytes(file.toPath()), responseHeaders, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respEntity;
    }

    private JFreeChart genPieChart(List<PieCharRecordDto> pieCharDataDto){

        DefaultPieDataset dataset = new DefaultPieDataset();
        for(PieCharRecordDto pieCharRecord : pieCharDataDto) {
            dataset.setValue(pieCharRecord.getPaymentMethod()+"\n"+pieCharRecord.getPercentage()*100+"%", pieCharRecord.getPercentage());
        }

        JFreeChart chart = ChartFactory.createPieChart("Transaction Breakdown", dataset, true, true, false);
        chart.setBackgroundPaint(new Color(236, 237, 240));
        PiePlot plot = (PiePlot)chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setNoDataMessage("No data available");

        return chart;
    }

    private JFreeChart genBarChart(List<DailyTxnAmtDto> dailyTxnAmtDtos){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(DailyTxnAmtDto record: dailyTxnAmtDtos){
            dataset.addValue(record.getAmt(),"Txn amount",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Txn amt per day",
                "Date",
                "Amount",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        return chart;
    }

    private JFreeChart genStackedBarChart(List<DailyTxnAmtDetailDto> recordsDto){
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        for(DailyTxnAmtDetailDto record: recordsDto) {
            result.setValue(record.getTapngoAmt(),"Tap&Go",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
            result.setValue(record.getVisaAmt(),"Visa",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
            result.setValue(record.getMasterAmt(),"Matser",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
            result.setValue(record.getOctopusAmt(),"Octopus",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
            result.setValue(record.getAlipayAmt(),"Alipay",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
            result.setValue(record.getWechatAmt(),"Wechat",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
            result.setValue(record.getFpsAmt(),"FPS",new SimpleDateFormat("yyyy-MM-dd").format(record.getDate()));
        }

        JFreeChart chart = ChartFactory.createStackedBarChart(
                "Txn Amt Per Day", "", "Amount",
                result, PlotOrientation.VERTICAL, true, true, false);

        chart.setBackgroundPaint(new Color(236, 237, 240));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(197, 117, 92));
        plot.getRenderer().setSeriesPaint(1, new Color(140, 207, 132));
        plot.getRenderer().setSeriesPaint(2, new Color(254, 249, 21));
        plot.getRenderer().setSeriesPaint(3, new Color(148, 182, 218));
        plot.getRenderer().setSeriesPaint(4, new Color(210, 224, 168));
        plot.getRenderer().setSeriesPaint(5, new Color(139, 127, 171));
        plot.getRenderer().setSeriesPaint(6, new Color(22, 220, 175));

        return chart;
    }

}

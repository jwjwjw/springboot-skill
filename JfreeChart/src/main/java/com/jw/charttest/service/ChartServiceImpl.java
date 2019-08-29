package com.jw.charttest.service;


import com.jw.charttest.model.DailyTxnAmtDetailDto;
import com.jw.charttest.model.DailyTxnAmtDto;
import com.jw.charttest.model.PieCharRecordDto;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    @Override
    public List<PieCharRecordDto> getPieChartTestData() {

        List<PieCharRecordDto> pieCharRecords = new ArrayList<>();
        PieCharRecordDto recordDto = new PieCharRecordDto();
        recordDto.setPaymentMethod("Visa");
        recordDto.setAmount(50);
        recordDto.setPercentage(0.1);
        pieCharRecords.add(recordDto);

        recordDto = new PieCharRecordDto();
        recordDto.setPaymentMethod("Master");
        recordDto.setAmount(100);
        recordDto.setPercentage(0.2);
        pieCharRecords.add(recordDto);

        recordDto = new PieCharRecordDto();
        recordDto.setPaymentMethod("Alipay");
        recordDto.setAmount(200);
        recordDto.setPercentage(0.4);
        pieCharRecords.add(recordDto);

        recordDto = new PieCharRecordDto();
        recordDto.setPaymentMethod("Wechat");
        recordDto.setAmount(150);
        recordDto.setPercentage(0.3);
        pieCharRecords.add(recordDto);

        return pieCharRecords;

    }

    @Override
    public List<DailyTxnAmtDto> getBarChartTestData(){
        List<DailyTxnAmtDto> records = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try{
            records.add(new DailyTxnAmtDto(sdf.parse("20180817"), 300));
            records.add(new DailyTxnAmtDto(sdf.parse("20180818"), 400));
            records.add(new DailyTxnAmtDto(sdf.parse("20180819"), 500));
            records.add(new DailyTxnAmtDto(sdf.parse("20180820"), 200));
            records.add(new DailyTxnAmtDto(sdf.parse("20180821"), 700));

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return records;
    }

    @Override
    public List<DailyTxnAmtDetailDto> getStackedBarChartTestData() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            List<DailyTxnAmtDetailDto> dailtAmtRecords = new ArrayList<>();
            DailyTxnAmtDetailDto dailyTxnVolumnDto = new DailyTxnAmtDetailDto();
            dailyTxnVolumnDto.setDate(sdf.parse("20180817"));
            dailyTxnVolumnDto.setVisaAmt(100);
            dailyTxnVolumnDto.setMasterAmt(200);
            dailyTxnVolumnDto.setAlipayAmt(150);
            dailyTxnVolumnDto.setTapngoAmt(70);
            dailyTxnVolumnDto.setFpsAmt(400);
            dailtAmtRecords.add(dailyTxnVolumnDto);

            dailyTxnVolumnDto = new DailyTxnAmtDetailDto();
            dailyTxnVolumnDto.setDate(sdf.parse("20180818"));
            dailyTxnVolumnDto.setVisaAmt(200);
            dailyTxnVolumnDto.setMasterAmt(300);
            dailyTxnVolumnDto.setAlipayAmt(250);
            dailyTxnVolumnDto.setTapngoAmt(100);
            dailyTxnVolumnDto.setWechatAmt(500);
            dailtAmtRecords.add(dailyTxnVolumnDto);

            dailyTxnVolumnDto = new DailyTxnAmtDetailDto();
            dailyTxnVolumnDto.setDate(sdf.parse("20180819"));
            dailyTxnVolumnDto.setVisaAmt(400);
            dailyTxnVolumnDto.setMasterAmt(200);
            dailyTxnVolumnDto.setAlipayAmt(150);
            dailyTxnVolumnDto.setTapngoAmt(300);
            dailyTxnVolumnDto.setWechatAmt(200);
            dailyTxnVolumnDto.setFpsAmt(200);
            dailtAmtRecords.add(dailyTxnVolumnDto);

            dailyTxnVolumnDto = new DailyTxnAmtDetailDto();
            dailyTxnVolumnDto.setDate(sdf.parse("20180820"));
            dailyTxnVolumnDto.setVisaAmt(250);
            dailyTxnVolumnDto.setAlipayAmt(200);
            dailyTxnVolumnDto.setTapngoAmt(240);
            dailyTxnVolumnDto.setWechatAmt(300);
            dailtAmtRecords.add(dailyTxnVolumnDto);

            dailyTxnVolumnDto = new DailyTxnAmtDetailDto();
            dailyTxnVolumnDto.setDate(sdf.parse("20180821"));
            dailyTxnVolumnDto.setVisaAmt(300);
            dailyTxnVolumnDto.setMasterAmt(100);
            dailyTxnVolumnDto.setAlipayAmt(400);
            dailyTxnVolumnDto.setTapngoAmt(200);
            dailyTxnVolumnDto.setWechatAmt(200);
            dailtAmtRecords.add(dailyTxnVolumnDto);

            return dailtAmtRecords;


        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

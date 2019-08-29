package com.jw.charttest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
public class DailyTxnAmtDetailDto {
    private Date date;
    private double visaAmt;
    private double octopusAmt;
    private double masterAmt;
    private double wechatAmt;
    private double alipayAmt;
    private double fpsAmt;
    private double cupAmt;
    private double amexAmt;
    private double tapngoAmt;
}

package com.jw.charttest.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PieCharRecordDto {

    private String paymentMethod;
    private double percentage;
    private double amount;
}

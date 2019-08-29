package com.jw.charttest.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class DailyTxnAmtDto {

    private Date date;
    private double amt;

    public DailyTxnAmtDto(Date date, double amt){
        this.date =date;
        this.amt = amt;
    }

}

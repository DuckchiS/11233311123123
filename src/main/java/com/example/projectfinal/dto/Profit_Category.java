package com.example.projectfinal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Builder
@Getter
@Setter
public class Profit_Category {
    private String category_name;
    private int date_profit;

    @Temporal(TemporalType.DATE)
    private Date date;
}

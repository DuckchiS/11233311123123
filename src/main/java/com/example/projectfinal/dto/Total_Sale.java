package com.example.projectfinal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Total_Sale {
    private String item_name;
    private int total_sale;
}

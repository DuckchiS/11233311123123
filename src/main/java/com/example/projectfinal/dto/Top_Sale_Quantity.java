package com.example.projectfinal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Top_Sale_Quantity {
    private String item_name;
    private int quantity;
}

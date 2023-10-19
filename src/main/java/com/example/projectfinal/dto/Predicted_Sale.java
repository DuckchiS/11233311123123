package com.example.projectfinal.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Predicted_Sale {
    private int sale_rate;
}

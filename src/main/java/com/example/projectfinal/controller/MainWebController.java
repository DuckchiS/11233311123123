package com.example.projectfinal.controller;

import com.example.projectfinal.dto.Top_Sale_Quantity;
import com.example.projectfinal.service.MainWebService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class MainWebController {
    private MainWebService mainWebService;

    public MainWebController(MainWebService mainWebService){
        this.mainWebService = mainWebService;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> test(){
        Map<String, Object> result = new HashMap<>();

        List<Top_Sale_Quantity> topList = mainWebService.topQuantity();
        result.put("Total_Sale_Rank", topList);
        int totalSale = mainWebService.totalSales();
        result.put("Total_Sale", totalSale);
//        int predictionSale = mainWebService.predictionSales();
//        result.put("Prediction_Sale", predictionSale);


        return ResponseEntity.ok().body(result);
    }
}

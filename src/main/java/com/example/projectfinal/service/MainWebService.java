package com.example.projectfinal.service;

import com.example.projectfinal.dto.Top_Sale_Quantity;
import com.example.projectfinal.dto.Total_Sale;
import com.example.projectfinal.model.entity.Orders;
import com.example.projectfinal.model.entity.Predictions;
import com.example.projectfinal.repository.OrderRepository;
import com.example.projectfinal.repository.PredictionsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainWebService {
    private OrderRepository orderRepository;
    private PredictionsRepository predictionsRepository;

    public MainWebService(
            OrderRepository orderRepository,
            PredictionsRepository predictionsRepository){
        this.orderRepository = orderRepository;
        this.predictionsRepository = predictionsRepository;
    }

    public List<Top_Sale_Quantity> topQuantity(){
        List<Orders> orders = orderRepository.findAll();

        List<Top_Sale_Quantity> orderVOList = orders.stream()
                .sorted(Comparator.comparing(Orders::getOrder_Quantity).reversed()) // quantity 역순으로 정렬
                .map(orderEntity -> Top_Sale_Quantity.builder()
                        .quantity(orderEntity.getOrder_Quantity())
                        .item_name(orderEntity.getItem().getItem_Name())
                        .build()
                )
                .limit(3)
                .collect(Collectors.toList());
        return orderVOList;
    }

    public int totalSales(){
        List<Orders> orders = orderRepository.findAll();

        int total = orders.stream()
                .mapToInt(order -> order.getOrder_Quantity() * order.getItem().getPrice())
                .sum(); // 각 주문의 총 가격을 합산

        return total;
    }

    public int predictionSales(){
        List<Predictions> predictions = predictionsRepository.findAll();

        int total = predictions.stream()
                .mapToInt(prediction -> prediction.getPredicted_item_cnt() * prediction.getItem().getPrice())
                .sum();
        return total;
    }


}

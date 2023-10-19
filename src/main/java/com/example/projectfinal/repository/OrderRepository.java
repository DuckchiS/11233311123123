package com.example.projectfinal.repository;

import com.example.projectfinal.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {
    @Query("select o.Order_Quantity * o.Order_Price from Orders o")
    Integer getTotalShops();


    @Query("select o from Orders o")
    List<Orders> findTopByOrder_QuantityOrderByOrder_QuantityDesc();
}

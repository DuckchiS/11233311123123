package com.example.projectfinal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "predictions", schema = "predictions_schema")
public class Predictions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private int shop_id;
    @OneToOne
    private Item item;

    private int real_item_cnt;
    private int predicted_item_cnt;
    private Date createdat;
}

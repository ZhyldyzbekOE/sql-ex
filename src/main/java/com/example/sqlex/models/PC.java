package com.example.sqlex.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class PC {

    @Id
    private Long code;
    @ManyToOne
    @JoinColumn(name = "model")
    private Product product;
    private int speed;
    private int ram;
    private double hd;
    private String cd;
    private double price;
}

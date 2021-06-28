package com.example.sqlex.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Laptop {

    @Id
    private Long code;
    @ManyToOne
    @JoinColumn(name = "model")
    private Product product;
    private int speed;
    private int ram;
    private double hd;
    private double price;
    private int screen;


}

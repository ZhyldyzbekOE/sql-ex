package com.example.sqlex.models.tasks;

import com.example.sqlex.enums.PrinterType;
import com.example.sqlex.models.Product;
import lombok.Data;

@Data
public class Task4Printer {
    private Long code;
    private String model;
    private String color;
    private PrinterType type;
    private double price;

}

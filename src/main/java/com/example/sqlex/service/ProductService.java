package com.example.sqlex.service;

import com.example.sqlex.enums.ProductType;
import com.example.sqlex.models.tasks.Task2Product;
import com.example.sqlex.models.tasks.Task8;

import java.util.List;

public interface ProductService {

    List<Task2Product> findByMakerPrinter(ProductType type);

    List<Task8> findPcMaker(ProductType type, ProductType type1);

}

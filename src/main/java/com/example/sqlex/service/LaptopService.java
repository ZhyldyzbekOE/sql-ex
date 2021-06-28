package com.example.sqlex.service;

import com.example.sqlex.models.Laptop;
import com.example.sqlex.models.tasks.Task3Laptop;
import com.example.sqlex.models.tasks.Task6;

import java.util.List;

public interface LaptopService {

    List<Task3Laptop> selectAllWherePriceGreaterThan(double price);

    List<Task6> findLaptopByHd(double hd);
}

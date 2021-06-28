package com.example.sqlex.service;

import com.example.sqlex.models.tasks.Task1PC;
import com.example.sqlex.models.tasks.Task5;
import com.example.sqlex.models.tasks.Task9;

import java.util.*;

public interface PCService {

    List<Task1PC>findByPriceLess(double price);

    List<Task5>findByCdAndPrice(Collection<String> cd, double price);

    List<Task9>findPcBySpeed(int speed);
}

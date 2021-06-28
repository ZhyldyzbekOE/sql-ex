package com.example.sqlex.service;

import com.example.sqlex.models.tasks.Task10;
import com.example.sqlex.models.tasks.Task4Printer;

import java.util.List;

public interface PrinterService {

    List<Task4Printer> findAllPrinterByColor(String color);

    List<Task10> findMaxPriceFromPrinter();
}

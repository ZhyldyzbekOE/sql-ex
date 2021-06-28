package com.example.sqlex.service.impl;

import com.example.sqlex.enums.ProductType;
import com.example.sqlex.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private PCService pcService;

    @Autowired
    private ProductService productService;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private PrinterService printerService;

    @Override
    public Object execute(String taskNum) {

        if (taskNum.equals("1")){
            return pcService.findByPriceLess(500);
        }
        else if (taskNum.equals("2")){
            return productService.findByMakerPrinter(ProductType.Printer);
        }
        else if (taskNum.equals("3")){
            return laptopService.selectAllWherePriceGreaterThan(1000);
        }
        else if (taskNum.equals("4")){
            return printerService.findAllPrinterByColor("y");
        }
        else if (taskNum.equals("5")){
            return pcService.findByCdAndPrice(Arrays.asList("12x", "24x"), 600);
        }
        else if (taskNum.equals("6")){
            return laptopService.findLaptopByHd(10);
        }
        else if (taskNum.equals("8")){
            return productService.findPcMaker(ProductType.PC, ProductType.Laptop);
        }
        else if (taskNum.equals("9")){
            return pcService.findPcBySpeed(450);
        }
        else if (taskNum.equals("10")){
            return printerService.findMaxPriceFromPrinter();
        }
        return null;
    }

}

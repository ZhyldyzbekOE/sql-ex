package com.example.sqlex.service.impl;

import com.example.sqlex.dao.PrinterRepository;
import com.example.sqlex.models.Printer;
import com.example.sqlex.models.tasks.Task10;
import com.example.sqlex.models.tasks.Task4Printer;
import com.example.sqlex.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrinterServiceImpl implements PrinterService {

    @Autowired
    private PrinterRepository printerRepository;

    @Override
    public List<Task4Printer> findAllPrinterByColor(String color) {
        List<Printer> printers = printerRepository.findAllByColorEquals(color);
        List<Task4Printer> task4Printers = printers.stream()
                .map(x->{
                    Task4Printer task4Printer = new Task4Printer();
                    task4Printer.setCode(x.getCode());
                    task4Printer.setModel(x.getProduct().getModel());
                    task4Printer.setColor(x.getColor());
                    task4Printer.setType(x.getType());
                    task4Printer.setPrice(x.getPrice());
                    return task4Printer;
                })
                .collect(Collectors.toList());
        return task4Printers;
    }

    @Override
    public List<Task10> findMaxPriceFromPrinter() {
        List<Printer> printers = printerRepository.findMaxPrinterPrice();
        List<Task10> task10List = printers.stream()
                .map(x -> {
                    Task10 task10 = new Task10();
                    task10.setModel(x.getProduct().getModel());
                    task10.setPrice(x.getPrice());
                    return task10;
                })
                .collect(Collectors.toList());
        return task10List;
    }
}

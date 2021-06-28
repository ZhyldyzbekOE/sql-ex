package com.example.sqlex.service.impl;

import com.example.sqlex.dao.LaptopRepository;
import com.example.sqlex.mappers.LaptopMapper;
import com.example.sqlex.models.Laptop;
import com.example.sqlex.models.dto.LaptopDto;
import com.example.sqlex.models.tasks.Task3Laptop;
import com.example.sqlex.models.tasks.Task6;
import com.example.sqlex.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Task3Laptop> selectAllWherePriceGreaterThan(double price) {
        List<Laptop> laptops = laptopRepository.findAllByPriceGreaterThan(price);
        List<Task3Laptop> task3LaptopList = laptops.stream()
                .map(x ->{
                    Task3Laptop task3Laptop = new Task3Laptop();
                    task3Laptop.setModel(x.getProduct().getModel());
                    task3Laptop.setRam(x.getRam());
                    task3Laptop.setScreen(x.getScreen());
                    return task3Laptop;
                })
                .collect(Collectors.toList());
        return task3LaptopList;
    }

    @Override
    public List<Task6> findLaptopByHd(double hd) {
        List<Laptop> laptops = laptopRepository.findByHd(hd);
        List<Task6> task6List = laptops.stream()
                .distinct()
                .map(x ->{
                    Task6 task6 = new Task6();
                    task6.setMaker(x.getProduct().getMaker());
                    task6.setSpeed(x.getSpeed());
                    return task6;
                })
                .collect(Collectors.toList());
        return task6List;
    }
}

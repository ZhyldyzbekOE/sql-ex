package com.example.sqlex.service.impl;

import com.example.sqlex.dao.PCRepository;
import com.example.sqlex.models.PC;
import com.example.sqlex.models.tasks.Task1PC;
import com.example.sqlex.models.tasks.Task5;
import com.example.sqlex.models.tasks.Task9;
import com.example.sqlex.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PCServiceImpl implements PCService {

    @Autowired
    private PCRepository pcRepository;

    @Override
    public List<Task1PC> findByPriceLess(double price) {

        List<PC> pcs = pcRepository.findAllByPriceLessThan(price);

        List<Task1PC> task1PCList = pcs.stream()
                // вот тут происходит преобразование Entity в DTO
                // мы получили PC, а должны отравить в контроллер PcDto
                // Task1 это и есть наш DTO
                .map(x -> {
                    Task1PC task1PC = new Task1PC();
                    task1PC.setModel(x.getProduct().getModel());
                    task1PC.setHd(x.getHd());
                    task1PC.setSpeed(x.getSpeed());
                    return task1PC;
                }).collect(Collectors.toList());

        return task1PCList;
    }

    @Override
    public List<Task5> findByCdAndPrice(Collection<String> cd, double price) {
        List<PC> pcs = pcRepository.findByCdInAndPriceLessThan(cd, price);
        List<Task5> task5List = pcs.stream()
                .map(x -> {
                    Task5 task5 = new Task5();
                    task5.setModel(x.getProduct().getModel());
                    task5.setSpeed(x.getSpeed());
                    task5.setHd(x.getHd());
                    return  task5;
                })
                .collect(Collectors.toList());
        return task5List;
    }

    @Override
    public List<Task9> findPcBySpeed(int speed) {
        List<PC> pcs = pcRepository.findBySpeed(speed);
        for (PC pc : pcs) {
            System.out.println(pc);
        }
        List<String> pcMakers = new ArrayList<>();
        for (PC p : pcs) {
            pcMakers.add(p.getProduct().getMaker());
        }
        List<Task9> task9s = pcMakers.stream()
                .distinct()
                .map(x -> {
                    Task9 task9 = new Task9();
                    task9.setMaker(x);
                    return task9;
                })
                .collect(Collectors.toList());
        return task9s;
    }
}

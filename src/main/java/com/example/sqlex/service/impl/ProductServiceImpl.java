package com.example.sqlex.service.impl;

import com.example.sqlex.dao.ProductRepository;
import com.example.sqlex.enums.ProductType;
import com.example.sqlex.models.Product;
import com.example.sqlex.models.tasks.Task2Product;
import com.example.sqlex.models.tasks.Task8;
import com.example.sqlex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Task2Product> findByMakerPrinter(ProductType type) {
        List<Product> products = productRepository.findDistinctMakerByType(type);
        List<String> strings = new ArrayList<>();
        for (Product product : products) {
            strings.add(product.getMaker());
        }
        List<Task2Product> task2ProductList = strings.stream()
                .distinct()
                .map(x->{
                    Task2Product task2Product = new Task2Product();
                    task2Product.setMaker(x);
                    return task2Product;
                })
                .collect(Collectors.toList());
        return task2ProductList;
    }

    @Override
    public List<Task8> findPcMaker(ProductType type, ProductType type1) {
//        List<Product> products = productRepository.findByPcMaker(type, type1);
//        List<Task8> task8List = products.stream()
//                .distinct()
//                .map(x -> {
//                    Task8 task8 = new Task8();
//                    task8.setMaker(x.getMaker());
//                    return task8;
//                })
//                .collect(Collectors.toList());
        return productRepository.findByPcMaker(type, type1);
    }
}

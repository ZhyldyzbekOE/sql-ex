package com.example.sqlex.dao;

import com.example.sqlex.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    List<Laptop> findAllByPriceGreaterThan(double price);

    @Query(value = "SELECT * FROM product p INNER JOIN laptop l ON p.model = l.model WHERE l.hd >= ?1 ORDER BY speed, maker" ,nativeQuery = true)
    List<Laptop> findByHd(double hd);

}

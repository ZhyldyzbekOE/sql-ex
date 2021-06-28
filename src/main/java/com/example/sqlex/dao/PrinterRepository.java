package com.example.sqlex.dao;

import com.example.sqlex.models.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Long> {

    List<Printer> findAllByColorEquals(String color);

    @Query(value = "SELECT * FROM printer p WHERE p.price = (SELECT MAX(price) FROM printer)", nativeQuery = true)
    List<Printer> findMaxPrinterPrice();
}

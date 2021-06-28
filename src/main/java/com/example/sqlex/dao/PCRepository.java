package com.example.sqlex.dao;

import com.example.sqlex.models.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PCRepository extends JpaRepository<PC, Long> {

    List<PC> findAllByPriceLessThan(double price);

    List<PC> findByCdInAndPriceLessThan(Collection<String> cd, double price);

    @Query(value = "SELECT * FROM pc WHERE pc.speed >= ?1",nativeQuery = true)
    List<PC> findBySpeed(int speed);

//    @Query(value = "SELECT * FROM pc INNER JOIN product p ON pc.model = p.model WHERE pc.speed >= ?1",nativeQuery = true)
//    List<PC> findBySpeed(int speed);

}

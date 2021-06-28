package com.example.sqlex.dao;

import com.example.sqlex.enums.ProductType;
import com.example.sqlex.models.Product;
import com.example.sqlex.models.tasks.Task8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findDistinctMakerByType(ProductType type);

//    @Query(value = "SELECT * FROM product p WHERE p.type = 'PC' AND p.maker not in (select * FROM product p1" +
//            " WHERE p1.type = 'Laptop')",nativeQuery = true)
//    List<Product> findByPcMaker(ProductType type, ProductType type1);

    @Query("select distinct new com.example.sqlex.models.tasks.Task8(p.maker) from Product p where p.type = ?1 " +
            "and p.maker not in (select p1.maker from Product p1 where p1.type = ?2)")
    List<Task8> findByPcMaker(ProductType type, ProductType type1);


}

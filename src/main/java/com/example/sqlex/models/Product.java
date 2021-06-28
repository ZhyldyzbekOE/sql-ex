package com.example.sqlex.models;

import com.example.sqlex.enums.ProductType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Product{

    @Id
    private String model;
    private String maker;
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(maker, product.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maker);
    }
}

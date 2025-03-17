package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // JpaRepository cung cấp sẵn các phương thức như save, findAll, findById, delete, v.v.
}

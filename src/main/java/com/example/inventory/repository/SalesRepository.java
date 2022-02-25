package com.example.inventory.repository;


import com.example.inventory.model.Order;
import com.example.inventory.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    Sales findBySalesNumber(String s);

    List<Sales> findAllByIngredient_Id(Long id);
}

package com.example.inventory.repository;

import com.example.inventory.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByInvoiceNumber(Long invoiceNumber);

    Order save(Order orderObject);
    List<Order> findAllByIngredient_Id(Long id);
}

package com.example.inventory.service;


import com.example.inventory.exceptions.InformationExistException;
import com.example.inventory.exceptions.InformationNotFoundException;
import com.example.inventory.model.Ingredient;
import com.example.inventory.model.Order;
import com.example.inventory.repository.IngredientRepository;
import com.example.inventory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    private IngredientRepository ingredientRepository;

    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }


    public Order createOrder(Long ingredientId, Order orderObject) {

        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if(ingredient.isEmpty()){
            throw new InformationNotFoundException("ingredient with id " + ingredientId + " does not exist");
        }

        Order order = orderRepository.findByInvoiceNumber(orderObject.getInvoiceNumber());
        if(order != null){
            throw new InformationExistException("order with invoice number " + order.getInvoiceNumber() + " already exists");
        }
        orderObject.setIngredient(ingredient.get());
        return orderRepository.save(orderObject);
    }

    public List<Ingredient> getAllOrders(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            return order.get().getIngredientList();
        } else {
            throw new InformationNotFoundException("ingredient with id " + orderId + " does not exist");
        }
    }
    public Order getOrder(Long ingredientId, Long orderId){
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if(ingredient == null) {
            throw new InformationNotFoundException("ingredient with id " + ingredientId + " does not exist");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()){
            throw new InformationNotFoundException("order with id " + orderId + " does not exist");
        }
        return order.get();
    }
}

package com.example.inventory.service;


import com.example.inventory.exceptions.InformationExistException;
import com.example.inventory.exceptions.InformationNotFoundException;
import com.example.inventory.model.Ingredient;
import com.example.inventory.model.Order;
import com.example.inventory.model.Sales;
import com.example.inventory.repository.IngredientRepository;
import com.example.inventory.repository.OrderRepository;
import com.example.inventory.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    private SalesRepository salesRepository;

    @Autowired
    public void setSalesRepository(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    private IngredientRepository ingredientRepository;

    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Sales createSales(Long ingredientId, Sales salesObject){
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if(ingredient.isEmpty()){
            throw new InformationNotFoundException("ingredient with id " + ingredientId + " does not exist");
        }
        Sales sales = salesRepository.findBySalesNumber(salesObject.getSalesNumber());
        if(sales != null) {
            throw new InformationExistException("sale with sales number " +sales.getSalesNumber() + " already exists");
        }
        salesObject.setIngredient(ingredient.get());
        return salesRepository.save(salesObject);
    }

    public List<Sales> getAllSales(Long ingredientId) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if(ingredient.isPresent()){
            return ingredient.get().getSalesList();
        } else {
            throw new InformationNotFoundException("ingredient with id " + ingredientId + " does not exist");
        }


    }

    public Sales getSales(Long ingredientId, Long salesId) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if(ingredient == null) {
            throw new InformationNotFoundException("ingredient with id " + ingredientId + " does not exist");
        }
        Optional<Sales> sales = salesRepository.findById(salesId);
        if(!sales.isPresent()){
            throw new InformationNotFoundException("order with id " + salesId + " does not exist");
        }
        return sales.get();
    }
}

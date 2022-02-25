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
        // 1. check if the ingredient is present
        // if not throw the error
        // else call the findAllByIngredient_Id
        // or else thorw no order for the current ingredient
//        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId );
//        List<Sales> sales = salesRepository.findAllByIngredient_Id(ingredientId);
//        if(sales.isEmpty()){
//            throw new InformationNotFoundException("sales with ingredient ID " + ingredientId + " not found");
//        }
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId );
        if(!ingredient.isPresent()){
            throw new InformationNotFoundException("ingredient with ID "+ ingredientId + " not found");
        }
        List<Sales> sales = salesRepository.findAllByIngredient_Id(ingredientId);
        if(sales.isEmpty()){
            throw new InformationNotFoundException("sales with ingredient ID " + ingredientId + " not found");
        }
        return sales;


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

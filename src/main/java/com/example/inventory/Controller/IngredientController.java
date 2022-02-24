package com.example.inventory.Controller;


import com.example.inventory.model.Ingredient;
import com.example.inventory.service.IngredientService;
import com.example.inventory.service.OrderService;
import com.example.inventory.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class IngredientController {

    private IngredientService ingredientService;


    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

//    private SalesService salesService;
//
//    @Autowired
//    public void setSalesService(SalesService salesService) {
//        this.salesService = salesService;
//    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients(){

        return ingredientService.getAllIngredients();
    }

    @PostMapping("/ingredients")
    public Ingredient createIngredient(@RequestBody Ingredient ingredientObject){
      return ingredientService.createIngredient(ingredientObject);
    }

    @GetMapping("/ingredients/{ingredientId}/")
    public Optional<Ingredient> getIngredient(@PathVariable(value = "ingredientId") Long ingredientId){
        return ingredientService.getIngredient(ingredientId);
    }

}

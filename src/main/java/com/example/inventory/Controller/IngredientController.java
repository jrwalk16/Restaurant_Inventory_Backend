package com.example.inventory.Controller;


import com.example.inventory.model.Ingredient;
import com.example.inventory.service.IngredientService;
import com.example.inventory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @PostMapping("/ingredients")
    public Ingredient createIngredient(@RequestBody Ingredient ingredientObject){
      return ingredientService.createIngredient(ingredientObject);
    }
}

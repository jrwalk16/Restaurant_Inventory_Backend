package com.example.inventory.Controller;


import com.example.inventory.model.Ingredient;
import com.example.inventory.model.Order;
import com.example.inventory.service.IngredientService;
import com.example.inventory.service.OrderService;
import com.example.inventory.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

    private IngredientService ingredientService;

    @Autowired
    public void setIngredientService(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    private SalesService salesService;

    @Autowired
    public void setSalesService(SalesService salesService){
        this.salesService = salesService;
    }

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/ingredients/{ingredientId}/order")
    public Order createOrder(@PathVariable(value = "ingredientId") Long ingredientId, @RequestBody Order orderObject){
        return orderService.createOrder(ingredientId, orderObject);
    }

    @GetMapping("/ingredients/{ingredientId}/order")
    public List<Order> getAllOrders(@PathVariable(value = "ingredientId")Long ingredientId){
        return orderService.getAllOrders(ingredientId);
    }

    @GetMapping("/ingredients/{ingredientId}/order/{orderId}")
    public Order getOrder(@PathVariable(value = "ingredientId") Long ingredientId, @PathVariable(value = "orderId") Long orderId){
        return orderService.getOrder(ingredientId, orderId);
    }


}

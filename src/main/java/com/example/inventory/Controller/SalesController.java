package com.example.inventory.Controller;


import com.example.inventory.model.Sales;
import com.example.inventory.service.IngredientService;
import com.example.inventory.service.OrderService;
import com.example.inventory.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class SalesController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService){
        this.orderService = orderService;
    }

    private SalesService salesService;

    @Autowired
    public void setSalesService(SalesService salesService){
        this.salesService = salesService;
    }

    private IngredientService ingredientService;

    @Autowired
    public void setIngredientService(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredients/{ingredientId}/sales/")
    public Sales createSales(@PathVariable(value = "ingredientId") Long ingredientId, @RequestBody Sales salesObject){
        return salesService.createSales(ingredientId, salesObject);
    }

    @GetMapping("/ingredients/{ingredientId}/sales/")
    public List<Sales> getAllSales(@PathVariable(value = "ingredientId")Long ingredientId){
        return salesService.getAllSales(ingredientId);
    }

    @GetMapping("/ingredients/{ingredientId}/sales/{salesId}")
    public Sales getSales(@PathVariable(value = "ingredientId") Long ingredientId, @PathVariable(value = "salesId") Long salesId){
        return salesService.getSales(ingredientId, salesId);
    }

}

package com.example.inventory.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ingredientName;



    @Column
    private Integer startingInventory;


    @Column
    private Integer inventoryOnHand;

    public Ingredient() {
    }

    public Ingredient(Long id, String ingredientName, Integer startingInventory, Integer inventoryOnHand) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.startingInventory = startingInventory;
        this.inventoryOnHand = inventoryOnHand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Integer getStartingInventory() {
        return startingInventory;
    }

    public void setStartingInventory(Integer startingInventory) {
        this.startingInventory = startingInventory;
    }


    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", startingInventory=" + startingInventory +
                ", inventoryOnHand=" + inventoryOnHand +
                '}';
    }

    public Integer getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(Integer inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }

    @OneToMany
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    @OneToMany
    private List<Sales> salesList;

    public List<Sales> getSalesList() {
        return salesList;
    }
}

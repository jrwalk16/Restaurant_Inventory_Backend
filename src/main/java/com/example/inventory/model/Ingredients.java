package com.example.inventory.model;

import javax.persistence.*;
import com.example.inventory.service.IngredientService;

@Entity
@Table(name = "ingredients")
public class Ingredients {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer startingInventory;

    @Column
    private Integer amountReceived;

    @Column
    private Integer inventorySold;

    @Column
    private Integer inventoryOnHand;

    public Ingredients() {
    }


    public Ingredients(Long id, Integer startingInventory, Integer amountReceived, Integer inventorySold, Integer inventoryOnHand) {
        this.id = id;
        this.startingInventory = startingInventory;
        this.amountReceived = amountReceived;
        this.inventorySold = inventorySold;
        this.inventoryOnHand = inventoryOnHand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStartingInventory() {
        return startingInventory;
    }

    public void setStartingInventory(Integer startingInventory) {
        this.startingInventory = startingInventory;
    }

    public Integer getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Integer amountReceived) {
        this.amountReceived = amountReceived;
    }

    public Integer getInventorySold() {
        return inventorySold;
    }

    public void setInventorySold(Integer inventorySold) {
        this.inventorySold = inventorySold;
    }

    public Integer getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(Integer inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", startingInventory=" + startingInventory +
                ", amountReceived=" + amountReceived +
                ", inventorySold=" + inventorySold +
                ", inventoryOnHand=" + inventoryOnHand +
                '}';
    }
}

package com.example.inventory.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long invoiceNumber;

    @Column
    private Integer amountReceived;


    @OneToOne
    private Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Order() {
    }

    public Order(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Order(Long id, Long invoiceNumber, Integer amountReceived) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.amountReceived = amountReceived;
    }

    public Integer getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Integer amountReceived) {
        this.amountReceived = amountReceived;
    }

    public Order(Long id, Integer amountReceived) {
        this.id = id;
        this.amountReceived = amountReceived;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", invoiceNumber=" + invoiceNumber +
                ", amountReceived=" + amountReceived +
                '}';
    }



    @OneToMany
    private List<Ingredient> ingredientList;

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}

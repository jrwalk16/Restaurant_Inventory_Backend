package com.example.inventory.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer amountReceived;

    public Order() {
    }

    public Order(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amountReceived=" + amountReceived +
                '}';
    }
}

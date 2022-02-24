package com.example.inventory.model;


import javax.persistence.*;

@Entity
@Table(name = "purchases")
public class Sales {
    

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer amountSold;

    public Sales() {
    }

    public Sales(Long id, Integer amountSold) {
        this.id = id;
        this.amountSold = amountSold;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(Integer amountSold) {
        this.amountSold = amountSold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", amountSold=" + amountSold +
                '}';
    }
}

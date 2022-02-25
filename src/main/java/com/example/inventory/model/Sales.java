package com.example.inventory.model;


import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {
    

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer amountSold;

    @Column
    private String salesNumber;

    @OneToOne
    private Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Sales() {
    }

    public Sales(Long id, Integer amountSold, String salesNumber) {
        this.id = id;
        this.amountSold = amountSold;
        this.salesNumber = salesNumber;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmountSold() {
        return amountSold;
    }

    public String getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(String salesNumber) {
        this.salesNumber = salesNumber;
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

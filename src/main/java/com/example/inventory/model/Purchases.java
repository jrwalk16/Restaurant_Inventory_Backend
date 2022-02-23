package com.example.inventory.model;


import javax.persistence.*;

@Entity
@Table(name = "purchases")
public class Purchases {
    

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Purchases() {
    }

    public Purchases(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + id +
                '}';
    }
}

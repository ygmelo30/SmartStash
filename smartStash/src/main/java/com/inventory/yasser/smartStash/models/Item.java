package com.inventory.yasser.smartStash.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Item {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private String supplier;
    @Column
    private int date_added;
    @Column
    private double price;
    @Column
    private int waste;



    public int getWaste() {
        return waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLow_stock_amount() {
        return low_stock_amount;
    }

    public void setLow_stock_amount(int low_stock_amount) {
        this.low_stock_amount = low_stock_amount;
    }

    public int getDate_added() {
        return date_added;
    }

    public void setDate_added(int date_added) {
        this.date_added = date_added;
    }

    int low_stock_amount;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }


}

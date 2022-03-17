package com.example.jsonexercise.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductWithBuyerDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String buyerFirstName;
    @Expose
    private String buyerLastname;

    public ProductWithBuyerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastname() {
        return buyerLastname;
    }

    public void setBuyerLastname(String buyerLastname) {
        this.buyerLastname = buyerLastname;
    }
}

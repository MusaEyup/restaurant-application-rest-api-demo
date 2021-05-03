package com.restaurant.Context;

import java.io.Serializable;

public class ItemContext implements Serializable {

    private Long id;
    private float price;
    private Long foodItemPortionId;
    private float quantity;
    private Long categoryId;

    public ItemContext(){
    }

    public ItemContext(Long id,   float quantity, Long categoryId) {
        this.id = id;


        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public ItemContext(Long id, float price, Long foodItemPortionId, float quantity, Long categoryId) {
        this.id = id;
        this.price = price;
        this.foodItemPortionId = foodItemPortionId;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getFoodItemPortionId() {
        return foodItemPortionId;
    }

    public void setFoodItemPortionId(Long foodItemPortionId) {
        this.foodItemPortionId = foodItemPortionId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


}

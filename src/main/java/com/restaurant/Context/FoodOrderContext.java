package com.restaurant.Context;


import com.restaurant.Entity.FoodItem_Portion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class FoodOrderContext implements Serializable {

    private Long orderId;
    private Long foodItemId;
    private Long foodItem_PortionId;
    private float quantity;
    private float price;
    private Long employeeId;
    private LocalDateTime _date;
    private FoodItem_Portion foodItemPortion;
    private List<ItemContext> itemList;

    public FoodOrderContext(){}

    public FoodOrderContext(Long orderId, Long foodItemPortionId, float quantity, float price, Long employeeId, LocalDateTime _date) {
        this.orderId = orderId;
        this.foodItem_PortionId = foodItemPortionId;
        this.quantity = quantity;
        this.price = price;
        this.employeeId = employeeId;
        this._date = _date;
    }

    public FoodOrderContext(Long orderId, Long employeeId, LocalDateTime _date, List<ItemContext> itemList) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this._date = _date;
        this.itemList = itemList;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime get_date() {
        return _date;
    }

    public void set_date(LocalDateTime _date) {
        this._date = _date;
    }

    public List<ItemContext> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemContext> itemList) {
        this.itemList = itemList;
    }

    public FoodItem_Portion getFoodItemPortion() {
        return foodItemPortion;
    }

    public void setFoodItemPortion(FoodItem_Portion foodItemPortion) {
        this.foodItemPortion = foodItemPortion;
    }

    public Long getFoodItem_PortionId() {
        return foodItem_PortionId;
    }

    public void setFoodItem_PortionId(Long foodItem_PortionId) {
        this.foodItem_PortionId = foodItem_PortionId;
    }
}

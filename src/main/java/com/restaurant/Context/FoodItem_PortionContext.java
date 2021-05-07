package com.restaurant.Context;

public class FoodItem_PortionContext {

    private Long id ;
    private String portionName;
    private Float ratio;
    private Float quantity;
    private Long foodItemId;
    private Long portionId;
    private Float price;

    public FoodItem_PortionContext() {
    }

    public FoodItem_PortionContext(Long id, String portionName, Float ratio, Float quantity, Long foodItemId, Long portionId, Float price) {
        this.id = id;
        this.portionName = portionName;
        this.ratio = ratio;
        this.quantity = quantity;
        this.foodItemId = foodItemId;
        this.portionId = portionId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortionName() {
        return portionName;
    }

    public void setPortionName(String portionName) {
        this.portionName = portionName;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Long getPortionId() {
        return portionId;
    }

    public void setPortionId(Long portionId) {
        this.portionId = portionId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}


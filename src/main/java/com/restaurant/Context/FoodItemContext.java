package com.restaurant.Context;



import java.util.List;

public class FoodItemContext {
    private String itemName;
    private Float quantity;
    private Long imageId;
    private Long categoryId;
    private List<PortionContext> portionContextList;


    public FoodItemContext() {
    }

    public FoodItemContext(String itemName, Float quantity, Long imageId, Long categoryId, List<PortionContext> portionContextList) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.imageId = imageId;
        this.categoryId = categoryId;
        this.portionContextList = portionContextList;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<PortionContext> getPortionContextList() {
        return portionContextList;
    }

    public void setPortionContextList(List<PortionContext> portionContextList) {
        this.portionContextList = portionContextList;
    }
}

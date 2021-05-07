package com.restaurant.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tblFOODITEM_PORTION")
public class FoodItem_Portion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float unitPrice;


    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "portion_id")
    private Portion portion;

    @OneToMany(mappedBy = "foodItem_Portion")
    private List<FoodItem_Order> foodItemOrder;

    private Boolean deleted;
    public FoodItem_Portion() {
    }

    public FoodItem_Portion(Long id, float unitPrice, FoodItem foodItem, Portion portion) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.foodItem = foodItem;
        this.portion = portion;
    }

    public FoodItem_Portion(float unitPrice, FoodItem foodItem, Portion portion) {
        this.unitPrice = unitPrice;
        this.foodItem = foodItem;
        this.portion = portion;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }


    public Portion getPortion() {
        return portion;
    }

    //@JsonIgnore
    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    @JsonIgnore
    public List<FoodItem_Order> getFoodItemOrder() {
        return foodItemOrder;
    }

    public void setFoodItemOrder(List<FoodItem_Order> foodItemOrder) {
        this.foodItemOrder = foodItemOrder;
    }

    public void setPortion(Portion portion) {
        this.portion = portion;
    }
}

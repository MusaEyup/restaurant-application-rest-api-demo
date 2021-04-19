package com.restaurant.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tblFOODITEM")
public class FoodItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private float quantity;
    private boolean deleted;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy="foodItem")
    private List<FoodItem_Portion> foodItemPortionList;

    @OneToOne
    @JoinColumn(name = "_image", referencedColumnName = "id")
    private ItemImages itemImages;


    public FoodItem(){};
    public FoodItem(Long id, String itemName, float quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public FoodItem(String itemName, float quantity, Category category) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //@JsonIgnore
    public ItemImages getItemImages() {
        return itemImages;
    }

    public void setItemImages(ItemImages itemImages) {
        this.itemImages = itemImages;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @JsonIgnore
    public List<FoodItem_Portion> getFoodItemPortionList() {
        return foodItemPortionList;
    }

    public void setFoodItemPortionList(List<FoodItem_Portion> foodItemPortionList) {
        this.foodItemPortionList = foodItemPortionList;
    }
}

package com.restaurant.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="tblIMAGE")
public class ItemImages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageName;

    @Lob
    private byte[] picture;

    @OneToOne(mappedBy = "itemImages")
    private FoodItem foodItem;


    public ItemImages() {
    }

    public ItemImages(String imageName, byte[] picture, FoodItem foodItem) {
        this.imageName = imageName;
        this.picture = picture;
        this.foodItem = foodItem;
    }

    public ItemImages(Long id, String imageName, byte[] picture, FoodItem foodItem) {
        this.id = id;
        this.imageName = imageName;
        this.picture = picture;
        this.foodItem = foodItem;
    }

    public ItemImages(String imageName, byte[] picture) {

        this.imageName = imageName;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String fileName) {
        this.imageName = fileName;
    }
   // @JsonIgnore
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @JsonIgnore
    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}

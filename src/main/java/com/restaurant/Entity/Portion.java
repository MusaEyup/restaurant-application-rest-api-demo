package com.restaurant.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "tblPORTION")
public class Portion implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private float calculate;

    @OneToMany(mappedBy="portion")
    private List<FoodItem_Portion> foodItemPortionList;


    public Portion(String name) {
        this.name = name;

    }
    public Portion(String name, float calculate) {
        this.name = name;
        this.calculate = calculate;

    }

    public Portion(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Portion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalculate() {
        return calculate;
    }

    public void setCalculate(float calculate) {
        this.calculate = calculate;
    }

    @JsonIgnore
    public List<FoodItem_Portion> getFoodItemPortionList() {
        return foodItemPortionList;
    }

    public void setFoodItemPortionList(List<FoodItem_Portion> foodItemPortionList) {
        this.foodItemPortionList = foodItemPortionList;
    }
}

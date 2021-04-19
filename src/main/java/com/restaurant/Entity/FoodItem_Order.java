package com.restaurant.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name ="tblFOODITEM_ORDER")
public class FoodItem_Order implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_id") // column name in db
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fp_id", referencedColumnName = "id")
    private FoodItem_Portion foodItem_Portion;

    private float quantity;
    private float price;
    private LocalDateTime _date;

    @ManyToOne
    private Employee employee;


    public FoodItem_Order() {
    }



    public FoodItem_Order(Order order, FoodItem_Portion foodItem_Portion, float quantity, float price, LocalDateTime _date, Employee employee) {
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this._date = _date;
        this.employee = employee;
        this.foodItem_Portion = foodItem_Portion;

    }

    public FoodItem_Order(Order order, FoodItem foodItem, float quantity, float price, String portion, LocalDateTime _date, Employee employee) {
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this._date = _date;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public FoodItem_Portion getFoodItem_Portion() {
        return foodItem_Portion;
    }

    public void setFoodItem_Portion(FoodItem_Portion foodItemPortion) {
        this.foodItem_Portion = foodItemPortion;
    }
}

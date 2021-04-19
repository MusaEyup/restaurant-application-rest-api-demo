package com.restaurant.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="tblORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean _status;
    private LocalDateTime startingDate;
    private LocalDateTime closingDate;

    @ManyToOne
    @JoinColumn(name ="table_id")
    private Tables table;


    @OneToMany(mappedBy="order")
    private List<FoodItem_Order> foodOrderList;



    public Order() {
    }

    public Order(boolean _status, LocalDateTime startingDate, Tables table) {
        this._status = _status;
        this.startingDate = startingDate;
        this.table = table;
    }

    public Order(boolean _status, LocalDateTime startingDate, LocalDateTime closingDate, Tables table) {
        this._status = _status;
        this.startingDate = startingDate;
        this.closingDate = closingDate;
        this.table = table;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean is_status() {
        return _status;
    }

    public void set_status(boolean _status) {
        this._status = _status;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public List<FoodItem_Order> getFoodOrderList() {
        return foodOrderList;
    }

    public void setFoodOrderList(List<FoodItem_Order> foodOrderList) {
        this.foodOrderList = foodOrderList;
    }
}

package com.restaurant.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tblTABLES")
public class Tables  implements Serializable {

    @Id
    private Long id;
    private int seatCount;

    private Boolean _status;
    private Boolean deleted;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;


    public Tables() {

    }

    public Tables(Long id, int seatCount, Boolean _status) {
        this.id = id;
        this.seatCount = seatCount;

        this._status = _status;
    }

    public Tables(Long id, int seatCount, Boolean _status, List<Order> orders) {
        this.id = id;
        this.seatCount = seatCount;

        this._status = _status;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean get_status() {
        return _status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean is_status() {
        return _status;
    }

    public void set_status(Boolean _status) {
        this._status = _status;
    }

    @JsonIgnore
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

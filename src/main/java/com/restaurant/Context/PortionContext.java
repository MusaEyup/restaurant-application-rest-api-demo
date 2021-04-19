package com.restaurant.Context;

public class PortionContext {
    private Long id;
    private String name;
    private Float ratio;
    private Float unitPrice;

    public PortionContext() {
    }

    public PortionContext(Long id, String name, Float ratio, Float unitPrice) {
        this.id = id;
        this.name = name;
        this.ratio = ratio;
        this.unitPrice = unitPrice;
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

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
}

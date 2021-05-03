package com.restaurant.Context;

import java.io.Serializable;

public class TablesContext implements Serializable {
    private Long tableId;
    private int seatCount;

    public TablesContext(Long tableId, int seatCount) {
        this.seatCount = seatCount;
        this.tableId = tableId;

    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }


}

package com.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PeriodicTable {
    @Id
    @Column(name="symbol_id")
    @GeneratedValue
    private int symbolId;
    private String symbol;
    private String element;

    public PeriodicTable() {
    }

    public PeriodicTable(String symbol, String element) {
        this.symbol = symbol;
        this.element = element;
    }

    public int getId() {
        return symbolId;
    }

    public void setId(int id) {
        this.symbolId = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}

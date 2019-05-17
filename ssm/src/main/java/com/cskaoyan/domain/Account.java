package com.cskaoyan.domain;

import java.io.Serializable;

public class Account implements Serializable {

    private Integer Id;
    private String name;
    private Double money;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

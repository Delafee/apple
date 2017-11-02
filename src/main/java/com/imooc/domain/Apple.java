package com.imooc.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Apple {

    @Id
    @GeneratedValue
    private Integer id;

    private String color;
    @Min(value =9, message =" price has to be >9")
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Apple() {

    }

    @Override
    public String toString()
    {
        return "Apple{" +
                "id=" + id +
                ", color'" + color + '\'' +
                ", price=" + price +
                '}';
    }

}

package com.university.ModuleHomework;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Lessons.BeerBottled
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.11.2020|02:18
 * @Version BeerBottled: 1.0
 */

public class BeerBottled implements IPrice {
    private String brand;
    private float price;

    public BeerBottled() { }

    public BeerBottled(String brand, float price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerBottled that = (BeerBottled) o;
        return Float.compare(that.getPrice(), getPrice()) == 0 &&
                getBrand().equals(that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getPrice());
    }

    @Override
    public String toString() {
        return "\"BeerBottled\" = {" +
                "'brand' : '" + brand + '\'' +
                ", 'price' : '" + price +
                "'}";
    }

    @Override
    public float getCost() {
        return this.getPrice();
    }
}
package com.university.ModuleHomework;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Lessons.BeerDraughted
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.11.2020|02:18
 * @Version BeerDraught: 1.0
 */

public class BeerDraught implements IPrice {
    private String brand;
    private float pint;
    private float pricePerPint;

    public BeerDraught() { }

    public BeerDraught(String brand, float pint, float pricePerPint) {
        this.brand = brand;
        this.pint = pint;
        this.pricePerPint = pricePerPint;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPint() {
        return pint;
    }

    public void setPint(float pint) {
        this.pint = pint;
    }

    public float getPricePerPint() {
        return pricePerPint;
    }

    public void setPricePerPint(float pricePerPint) {
        this.pricePerPint = pricePerPint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerDraught that = (BeerDraught) o;
        return Float.compare(that.getPint(), getPint()) == 0 &&
                Float.compare(that.getPricePerPint(), getPricePerPint()) == 0 &&
                getBrand().equals(that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getPint(), getPricePerPint());
    }

    @Override
    public String toString() {
        return "\"BeerDraught\" = {" +
                "'brand' : '" + brand + '\'' +
                ", 'pint' : '" + pint + '\'' +
                ", 'pricePerPint' : '" + pricePerPint + '\'' +
                '}';
    }

    @Override
    public float getCost() {
        return this.getPint() * this.getPricePerPint();
    }
}
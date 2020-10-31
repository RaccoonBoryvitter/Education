package com.university.LabWork6;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Lessons.Triangle
 *
 * @Autor: pavel
 * @DateTime: 01.10.2020|23:01
 * @Version Triangle: 1.0
 */

public class Triangle {
    // Поля сторон
    private float sideA;
    private float sideB;
    private float sideC;

    // Конструкторы
    public Triangle() { }

    public Triangle(float sideA, float sideB, float sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public float getSideA() {
        return sideA;
    }

    public void setSideA(float sideA) {
        if(sideA > 0 && TriangleFactory.isValidate(sideA, this.getSideB(), this.getSideC()))
            this.sideA = sideA;
        else {
            System.out.println("You entered an incorrect value of A-side");
        }
    }

    public float getSideB() {
        return sideB;
    }

    public void setSideB(float sideB) {
        if(sideB > 0 && TriangleFactory.isValidate(this.getSideA(), sideB, this.getSideC()))
            this.sideB = sideB;
        else {
            System.out.println("You entered an incorrect value of B-side");
        }
    }

    public float getSideC() {
        return sideC;
    }

    public void setSideC(float sideC) {
        if(sideC > 0 && TriangleFactory.isValidate(this.getSideA(), this.getSideB(), sideC))
            this.sideC = sideC;
        else {
            System.out.println("You entered an incorrect value of A-side");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.getSideA(), getSideA()) == 0 &&
                Float.compare(triangle.getSideB(), getSideB()) == 0 &&
                Float.compare(triangle.getSideC(), getSideC()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSideA(), getSideB(), getSideC());
    }

    @Override
    public String toString() {
        return "Triangle = [" +
                "a = " + this.sideA +
                ", b = " + this.sideB +
                ", c = " + this.sideC +
                ", alpha = " + String.format("%.2f", TriangleService.getAlphaAngle(this)) +
                ", beta = " + String.format("%.2f", TriangleService.getBetaAngle(this)) +
                ", gamma = " + String.format("%.2f", TriangleService.getGammaAngle(this)) +
                ']';
    }
}
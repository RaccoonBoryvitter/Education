package com.university.LabWork7;

/**
 * Created by IntelliJ IDEA.
 * Lessons.Rectangle
 *
 * @Autor: pavel
 * @DateTime: 02.10.2020|01:07
 * @Version Rectangle: 1.0
 */

public class Rectangle {
    private float height;
    private float width;

    public Rectangle() { }

    public Rectangle(float height) {
        this.height = height;
        this.width = height;
    }

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    public float getDiameter() {
        return (float)Math.sqrt(Math.pow(this.getHeight(), 2) + Math.pow(this.getWidth(), 2));
    }

    public float getPerimeter() {
        return 2 * (this.getHeight() + this.getWidth());
    }

    public float getArea() {
        return this.getHeight() * this.getWidth();
    }

    public float getExcircleRadius() {
        return this.getDiameter() / 2;
    }
}
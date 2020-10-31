package com.university.LabWork8;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Lessons.ConicalFrustum
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 23.10.2020|01:23
 * @Version ConicalFrustum: 1.0
 */

// POJO class

public class ConicalFrustum {
    private float lowerRadius;
    private float upperRadius;
    private float height;

    public ConicalFrustum() { }

    public ConicalFrustum(float lowerRadius, float upperRadius, float height) {
        this.lowerRadius   = lowerRadius;
        this.upperRadius   = upperRadius;
        this.height        = height;
    }

    public float getLowerRadius() {
        return lowerRadius;
    }

    public void setLowerRadius(float lowerRadius) {
        if (FrustumFactory.isValid(lowerRadius, this.upperRadius, this.height))
            this.lowerRadius = lowerRadius;
        else
            System.out.println("Incorrect value!");
    }

    public float getUpperRadius() {
        return upperRadius;
    }

    public void setUpperRadius(float upperRadius) {
        if (FrustumFactory.isValid(this.lowerRadius, upperRadius, this.height)) {
            this.upperRadius = upperRadius;
        } else {
            System.out.println("Incorrect value!"); 
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (FrustumFactory.isValid(this.lowerRadius, this.upperRadius, height)) {
            this.height = height;
        } else {
            System.out.println("Incorrect value!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConicalFrustum frustum = (ConicalFrustum) o;
        return Float.compare(frustum.getLowerRadius(), getLowerRadius()) == 0 &&
                Float.compare(frustum.getUpperRadius(), getUpperRadius()) == 0 &&
                Float.compare(frustum.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLowerRadius(), getUpperRadius(), getHeight());
    }

    @Override
    public String toString() {
        return "ConicalFrustum{" +
                "lowerRadius=" + lowerRadius +
                ", upperRadius=" + upperRadius +
                ", height=" + height +
                '}';
    }
}
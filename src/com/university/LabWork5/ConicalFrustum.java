package com.university.LabWork5;

public class ConicalFrustum {
    private float lowerRadius;
    private float upperRadius;
    private float height;

    // Constructors
    public ConicalFrustum(float lowerRadius, float upperRadius, float height) {
        this.height = height;
        if (lowerRadius > upperRadius) {
            this.lowerRadius = lowerRadius;
            this.upperRadius = upperRadius;
        } else {
            System.out.println("This IS NOT a conical frustrum");
            System.out.println("Error: upper radius CANNOT BE bigger than lower radius!\n");
        }
    }

    //Getters n' Setters
    public float getLowerRadius() {
        return this.lowerRadius;
    }

    public void setLowerRadius(float lowerRadius) {
        this.lowerRadius = lowerRadius;
    }

    public float getUpperRadius() {
        return this.upperRadius;
    }

    public void setUpperRadius(float upperRadius) {
        this.upperRadius = upperRadius;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    //Methods
    public double getSlantHeight() {
        double expr = Math.pow(this.getHeight(), 2) +
                Math.pow(this.getLowerRadius() - this.getUpperRadius(), 2);

        return Math.sqrt(expr);
    }

    public float getPreCutHeight() {
        return (this.getHeight() * this.getLowerRadius()) / (this.getLowerRadius() - this.getUpperRadius());
    }

    public double getSideArea() {
        return Math.PI * this.getSlantHeight() * (this.getLowerRadius() + this.getUpperRadius());
    }

    public double getFullArea() {
        return this.getSideArea() +
                (Math.PI * Math.pow(this.getLowerRadius(), 2)) +
                (Math.PI * Math.pow(this.getUpperRadius(), 2));
    }

    public double getVolume() {
        double sum = Math.pow(this.getLowerRadius(), 2) +
                this.getLowerRadius() * this.getUpperRadius() +
                Math.pow(this.getUpperRadius(), 2);

        return (Math.PI / 3.0) * this.getHeight() * sum;
    }

    public double getBoxVolume() {
        return 4 * Math.pow(this.getLowerRadius(), 2) * this.getHeight();
    }

    @Override
    public String toString() {
        String out = "Conical Frustum Object Information: " +
                "\n\tUpper Radius: " + this.getUpperRadius() +
                "\n\tLower Radius: " + this.getLowerRadius() +
                "\n\tHeight: " + this.getHeight();

        return out;
    }
}

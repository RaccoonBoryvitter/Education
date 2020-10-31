package com.university.LabWork7;

/**
 * Created by IntelliJ IDEA.
 * Lessons.Door
 *
 * @Autor: pavel
 * @DateTime: 02.10.2020|01:25
 * @Version Door: 1.0
 */

public class Door extends Rectangle {
    private String material;
    private String color;
    private String handleType;
    private String lockType;
    private float price;
    private int glassPanelAmount;

    public Door(float height, String material, String color, int glassPanelAmount, float price) {
        super(height);
        this.material = material;
        this.color = color;
        this.glassPanelAmount = glassPanelAmount;
        this.price = price;
    }

    public Door(float height, float width, String material, String color, int glassPanelAmount) {
        super(height, width);
        this.material = material;
        this.color = color;
        this.glassPanelAmount = glassPanelAmount;
    }

    public Door(float height, String handleType, String lockType) {
        super(height);
        this.handleType = handleType;
        this.lockType = lockType;
    }

    public Door(float height, float width, String handleType, String lockType) {
        super(height, width);
        this.handleType = handleType;
        this.lockType = lockType;
    }

    public Door(float height, String material, String color, String handleType, String lockType, int glassPanelAmount, float price) {
        super(height);
        this.material = material;
        this.color = color;
        this.handleType = handleType;
        this.lockType = lockType;
        this.glassPanelAmount = glassPanelAmount;
        this.price = price;
    }

    public Door(float height, float width, String material, String color, String handleType, String lockType, int glassPanelAmount, float price) {
        super(height, width);
        this.material = material;
        this.color = color;
        this.handleType = handleType;
        this.lockType = lockType;
        this.glassPanelAmount = glassPanelAmount;
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGlassPanelAmount() {
        return glassPanelAmount;
    }

    public void setGlassPanelAmount(int glassPanelAmount) {
        this.glassPanelAmount = glassPanelAmount;
    }

    @Override
    public String toString() {
        return "Door{" +
                "height = " + super.getHeight() +
                ", width = " + super.getWidth() +
                ", material = '" + this.material + '\'' +
                ", color = '" + this.color + '\'' +
                ", handleType = '" + this.handleType + '\'' +
                ", lockType = '" + this.lockType + '\'' +
                ", glassPanelAmount = " + this.glassPanelAmount +
                ", price = " + this.price +
                '}';
    }

    public void favouriteTrack() {
        System.out.println("If you listened to \"The Doors\" once in your life, then you are very good person");
        System.out.println("My favourite track of this band is \"Riders on the Storm\"");
    }
}
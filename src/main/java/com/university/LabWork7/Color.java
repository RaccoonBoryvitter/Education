package com.university.LabWork7;

/**
 * Created by IntelliJ IDEA.
 * Lessons.Color
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.11.2020|03:39
 * @Version Color: 1.0
 */

public class Color {
    private int red;
    private int green;
    private int blue;

    private Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(short red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(short green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(short blue) {
        this.blue = blue;
    }

    public static Color rgb(int r, int g, int b) {
        if (r <= 255 && g <= 255 && b <= 255)
            return new Color(r, g, b);
        else
            return null;
    }

    @Override
    public String toString() {
        return "Color{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
package com.university.LabWork5;

public class Main {
    public static void main(String[] args) {
        ConicalFrustum cF1 = new ConicalFrustum(8, 5, 4);
        ConicalFrustum CF2 = new ConicalFrustum(6, 9, 6);

        System.out.println(cF1);
        System.out.println("\nProcessing...");
        System.out.println("Slant height: " + cF1.getSlantHeight());
        System.out.println("Pre-cut height: " + cF1.getPreCutHeight());
        System.out.println("Side Area: " + cF1.getSideArea());
        System.out.println("Full Area: " + cF1.getFullArea());
        System.out.println("Volume: " + cF1.getVolume());
        System.out.println("You can put this conical frustum in the box with volume of " + cF1.getBoxVolume());
    }
}

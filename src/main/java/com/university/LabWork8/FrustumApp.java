package com.university.LabWork8;

/**
 * Created by IntelliJ IDEA.
 * Lessons.FrustumApp
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 30.10.2020|02:06
 * @Version FrustumApp: 1.0
 */

public class FrustumApp {
    public static void main(String[] args) {
        ConicalFrustum frustum1 = FrustumFactory.create(10, 7, 12);
        ConicalFrustum frustum2 = FrustumFactory.create(15, 9, 20);
        FrustumService service = new FrustumService();

        service.setCurrentFrustum(frustum1);
        System.out.println(frustum1);
        System.out.println("Slant Height: " + service.getSlantHeight());
        System.out.println("Pre-cut Height: " + service.getPreCutHeight());
        System.out.println("Side Area: " + service.getSideArea());
        System.out.println("Full Area: " + service.getArea());
        System.out.println("Volume: " + service.getVolume());
        System.out.println("JSON: " + "\n\t" + service.toJSON());
        System.out.println("XML: " + '\n' + service.toXML());

        System.out.println("\n=========================================================\n");

        service.setCurrentFrustum(frustum2);
        System.out.println(frustum2);
        System.out.println("Slant Height: " + service.getSlantHeight());
        System.out.println("Pre-cut Height: " + service.getPreCutHeight());
        System.out.println("Side Area: " + service.getSideArea());
        System.out.println("Full Area: " + service.getArea());
        System.out.println("Volume: " + service.getVolume());
        System.out.println("JSON: " + "\n\t" + service.toJSON());
        System.out.println("XML: " + '\n' + service.toXML());
    }
}
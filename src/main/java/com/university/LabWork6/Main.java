package com.university.LabWork6;

/**
 * Created by IntelliJ IDEA.
 * Lessons.Main
 *
 * @Autor: pavel
 * @DateTime: 02.10.2020|01:03
 * @Version Main: 1.0
 */

public class Main {
    public static void main(String[] args) {
        Triangle tr1 = TriangleFactory.withThreeSides(3.0f, 4.0f, 5.0f);
        Triangle tr2 = TriangleFactory.withTwoSidesAndAngle(6.0f, 8.0f, 90.0);

        System.out.println(tr1);
        System.out.println(tr2);
        System.out.println("Are these triangles similar? " + TriangleService.areSimilar(tr1, tr2));
        System.out.println("Are these triangles equal? " + tr1.equals(tr2));

        System.out.println("==================================================================================");

        Triangle tr3 = TriangleFactory.withTwoSidesAndAngle(5.0f, 5.0f, 60.0);
        System.out.println(tr3);
        System.out.println("Perimeter: " + TriangleService.getPerimeter(tr3));
        System.out.printf("Area: %.2f \n", TriangleService.getArea(tr3));
        System.out.printf("Inradius: %.2f \n", TriangleService.getInradius(tr3));
        System.out.printf("Circumradius: %.2f \n", TriangleService.getCircumradius(tr3));
        System.out.printf("Height to the side C: %.2f \n", TriangleService.getHeightC(tr3));
        System.out.println("XML: " + TriangleService.toXML(tr3));
        System.out.println("JSON: " + TriangleService.toJSON(tr3));

        System.out.println("==================================================================================");

        Triangle tr4 = TriangleFactory.withTwoAnglesAndOneSide(123, 214, 5.0f);
        System.out.println(tr4);
    }
}
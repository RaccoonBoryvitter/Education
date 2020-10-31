package com.university.LabWork6;

/**
 * Created by IntelliJ IDEA.
 * Lessons.TriangleService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 22.10.2020|23:46
 * @Version TriangleService: 1.0
 */

public class TriangleService {

    // Список Triangle
    // Методы CRUD

    public static float getPerimeter (Triangle triangle) {
        return triangle.getSideA() + triangle.getSideB() + triangle.getSideC();
    }

    public static double getArea(Triangle triangle) {
        float halfPerimeter  = TriangleService.getPerimeter(triangle) / 2;
        double expr          = halfPerimeter * (halfPerimeter - triangle.getSideA()) *
                (halfPerimeter - triangle.getSideB()) * (halfPerimeter - triangle.getSideC());
        return Math.sqrt(expr);

    }

    public static float getInradius(Triangle triangle) {
        float halfPerimeter = TriangleService.getPerimeter(triangle) / 2;
        return (float)(TriangleService.getArea(triangle) / halfPerimeter);
    }

    public static float getCircumradius(Triangle triangle) {
        double expr = (triangle.getSideA() * triangle.getSideB() * triangle.getSideC())
                / (4 * TriangleService.getArea(triangle));
        return (float)expr;
    }

    public static double getAlphaAngle(Triangle triangle) {
        float a       = triangle.getSideA();
        float b       = triangle.getSideB();
        float c       = triangle.getSideC();
        double expr   = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        double alpha  = Math.acos(expr);
        return Math.toDegrees(alpha);
    }

    public static double getBetaAngle(Triangle triangle) {
        float a      = triangle.getSideA();
        float b      = triangle.getSideB();
        float c      = triangle.getSideC();
        double expr  = (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c);
        double beta  = Math.acos(expr);
        return Math.toDegrees(beta);
    }

    public static double getGammaAngle(Triangle triangle) {
        float a       = triangle.getSideA();
        float b       = triangle.getSideB();
        float c       = triangle.getSideC();
        double expr   = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
        double gamma  = Math.acos(expr);
        return Math.toDegrees(gamma);
    }

    public static double getHeightA(Triangle triangle) {
        return 2 * TriangleService.getArea(triangle) / triangle.getSideA();
    }

    public static double getHeightB(Triangle triangle) {
        return 2 * TriangleService.getArea(triangle) / triangle.getSideB();
    }

    public static double getHeightC(Triangle triangle) {
        return 2 * TriangleService.getArea(triangle) / triangle.getSideC();
    }

    public static boolean areSimilar(Triangle t1, Triangle t2) {
        float firstSideProp = t1.getSideA() / t2.getSideA();
        float secondSideProp = t1.getSideB() / t2.getSideB();
        float thirdSideProp = t1.getSideC() / t2.getSideC();
        boolean firstStatement = (firstSideProp == secondSideProp) && (secondSideProp == thirdSideProp);
        boolean firstAngleProp = (TriangleService.getAlphaAngle(t1) == TriangleService.getAlphaAngle(t2));
        boolean secondAngleProp = (TriangleService.getBetaAngle(t1) == TriangleService.getBetaAngle(t2));
        boolean thirdAngleProp = (TriangleService.getGammaAngle(t1) == TriangleService.getGammaAngle(t2));

        return firstStatement && firstAngleProp && secondAngleProp && thirdAngleProp;
    }

    public static String toXML(Triangle tr) {
        return "\n<Triangle>" + '\n' +
                "\t<sideA>" + tr.getSideA() + "</sideA>" + '\n' +
                "\t<sideB>" + tr.getSideB() + "</sideB>" + '\n' +
                "\t<sideC>" + tr.getSideC() + "</sideC>" + '\n' +
                "</Triangle>";
    }

    public static String toJSON(Triangle tr) {
        return "\n\"Triangle\" = {'a' = " + tr.getSideA() +
                ", 'b' = " + tr.getSideB() +
                ", 'c' = " + tr.getSideC() + "}";
    }
}
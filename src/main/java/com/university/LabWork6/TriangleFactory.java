package com.university.LabWork6;

/**
 * Created by IntelliJ IDEA.
 * Lessons.TriangleFactory
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 22.10.2020|22:06
 * @Version TriangleFactory: 1.0
 */

public class TriangleFactory {

    public static Triangle withThreeSides(float sideA, float sideB, float sideC) {
        if (sideA > 0 && sideB > 0 && sideC > 0
                && TriangleFactory.isValidate(sideA, sideB, sideC)) {
            return new Triangle(sideA, sideB, sideC);
        } else {
            return null;
        }
    }

    public static Triangle withTwoSidesAndAngle(float sideA, float sideB, double gammaAngle) {
        double _gamma   = Math.toRadians(gammaAngle);
        double _expr    = Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(_gamma);
        float  sideC    = (float)Math.sqrt(_expr);

        if (sideA > 0 && sideB > 0 && sideC > 0
                && TriangleFactory.isValidate(sideA, sideB, sideC)) {
            return new Triangle(sideA, sideB, sideC);
        } else {
            return null;
        }
    }

    public static Triangle withTwoAnglesAndOneSide(double alphaAngle, double betaAngle, float sideC) {
        double _alpha   = Math.toRadians(alphaAngle);
        double _beta    = Math.toRadians(betaAngle);
        double _gamma   = Math.toRadians(180.0 - alphaAngle - betaAngle);
        float sideA = (float) ( Math.sin(_alpha) *  ( sideC / Math.sin(_gamma)) );
        float sideB = (float) ( Math.sin(_beta) * ( sideC / Math.sin(_gamma)));

        if (sideA > 0 && sideB > 0 && sideC > 0
                && TriangleFactory.isValidate(sideA, sideB, sideC)) {
            return new Triangle(sideA, sideB, sideC);
        } else {
            return null;
        }
    }

    public static boolean isValidate(float sideA, float sideB, float sideC) {
        boolean firstStatement   = (sideA + sideB) > sideC;
        boolean secondStatement  = (sideB + sideC) > sideA;
        boolean thirdStatement   = (sideA + sideC) > sideB;
        return firstStatement && secondStatement && thirdStatement;
    }
}
package com.university.LabWork8;

/**
 * Created by IntelliJ IDEA.
 * Lessons.FrustumFactory
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 23.10.2020|01:25
 * @Version FrustumFactory: 1.0
 */

public class FrustumFactory {

    public static ConicalFrustum create(float lowerRadius, float upperRadius, float height) {
        if (FrustumFactory.isValid(lowerRadius, upperRadius, height)) {
            return new ConicalFrustum(lowerRadius, upperRadius, height);
        } else {
            return null;
        }
    }

    public static boolean isValid(float lowerRadius, float upperRadius, float height) {
        return lowerRadius > 0 &&
                upperRadius > 0 &&
                height > 0 &&
                lowerRadius > upperRadius;
    }
}
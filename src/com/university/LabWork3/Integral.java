package com.university.LabWork3;

public class Integral {
    public static void main(String[] args) {

        System.out.println("\n[RECTANGLES METHOD]");
        double start = 0;
        double finish = Math.PI;
        int precision = 100000;
        double width = finish / precision;
        double restrictionYLine = 1.0;
        double currentX = 0;
        double rectangleIntegral = 0;

        for (int i = 0; i < precision; i++) {
            currentX += width;
            if (Math.sin(currentX) > restrictionYLine) {
                rectangleIntegral += width * Math.sin(restrictionYLine);
            } else {
                rectangleIntegral += width * Math.sin(currentX);
            }
        }

        System.out.println("Integral of sin(x) from " + start + " to " + finish + "\n" +
                "is equal to " + rectangleIntegral + " with precision of " + precision);

        System.out.println("\n[SIMPSON'S METHOD]");
        int parts = 100000;
        double simpsonIntegral = 0;

        simpsonIntegral += Math.sin(start);
        for(int i = 1; i <= parts - 1; i++) {
            if (i % 2 == 0)
                if (Math.sin(start + (finish - start) * i / parts) < restrictionYLine)
                    simpsonIntegral += 2 * Math.sin(start + (finish - start) * i / parts);
                else
                    simpsonIntegral += 2 * Math.sin(restrictionYLine);
            else {
                if (Math.sin(start + (finish - start) * i / parts) < restrictionYLine)
                    simpsonIntegral += 4 * Math.sin(start + (finish - start) * i / parts);
                else
                    simpsonIntegral += 4 * Math.sin(restrictionYLine);
            }
        }
        simpsonIntegral += Math.sin(start + (finish - start));

        simpsonIntegral *= (finish - start) / (3 * parts);

        System.out.println("Integral of sin(x) from " + start + " to " + finish + "\n" +
            "is equal to " + simpsonIntegral);
    }
}
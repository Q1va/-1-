package org.example;

public class DistanceCalculator {


    public static double distance2D(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


    public static double distance3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

    public static void main(String[] args) {

        double x1 = 1, y1 = 2;
        double x2 = 4, y2 = 6;
        System.out.printf("Відстань у 2D: %.2f%n", distance2D(x1, y1, x2, y2));


        double z1 = 3, z2 = 7;
        System.out.printf("Відстань у 3D: %.2f%n", distance3D(x1, y1, z1, x2, y2, z2));
    }
}

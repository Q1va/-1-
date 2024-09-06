package org.example;

public class PolarDistance {


    public static double polarDistance(double r1, double theta1, double r2, double theta2) {
        return Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - 2 * r1 * r2 * Math.cos(theta1 - theta2));
    }


    public static double sphericalDistance(double r, double theta1, double phi1, double theta2, double phi2) {
        return r * Math.acos(Math.sin(theta1) * Math.sin(theta2) + Math.cos(theta1) * Math.cos(theta2) * Math.cos(phi1 - phi2));
    }

    public static void main(String[] args) {
        // Полярна відстань
        double r1 = 5, theta1 = Math.toRadians(30);
        double r2 = 7, theta2 = Math.toRadians(60);
        System.out.printf("Полярна відстань: %.2f%n", polarDistance(r1, theta1, r2, theta2));

        // Сферична відстань
        double phi1 = Math.toRadians(30), phi2 = Math.toRadians(60);
        System.out.printf("Сферична відстань (велика колова): %.2f%n", sphericalDistance(5, theta1, phi1, theta2, phi2));
    }
}

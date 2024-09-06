package org.example;

import java.util.Random;

public class BenchmarkTable {


    public static double[][] generateCartesianPoints(int n) {
        Random rand = new Random();
        double[][] points = new double[n][3];
        for (int i = 0; i < n; i++) {
            points[i][0] = rand.nextDouble() * 100; // x
            points[i][1] = rand.nextDouble() * 100; // y
            points[i][2] = rand.nextDouble() * 100; // z
        }
        return points;
    }


    public static double benchmark(int n) {
        double[][] points = generateCartesianPoints(n);
        long startTime = System.nanoTime();


        for (int i = 0; i < n - 1; i++) {
            DistanceCalculator.distance3D(points[i][0], points[i][1], points[i][2],
                    points[i + 1][0], points[i + 1][1], points[i + 1][2]);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }


    public static void printTable(int[] numPoints, double[] times) {
        System.out.println("+-------------------+------------------------+");
        System.out.println("| Кількість точок   | Час виконання (мс)     |");
        System.out.println("+-------------------+------------------------+");

        for (int i = 0; i < numPoints.length; i++) {
            System.out.printf("| %-17d | %-22.2f |\n", numPoints[i], times[i]);
        }


        System.out.println("+-------------------+------------------------+");
    }

    public static void main(String[] args) {

        int[] numPoints = {1000, 5000, 10000, 20000, 30000, 40000, 50000};
        double[] times = new double[numPoints.length];

        for (int i = 0; i < numPoints.length; i++) {
            times[i] = benchmark(numPoints[i]);
            System.out.printf("Час виконання для %d точок: %.2f мс%n", numPoints[i], times[i]);
        }

        printTable(numPoints, times);
    }
}

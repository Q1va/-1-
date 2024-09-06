package org.example;

public class CoordinateConverter2D {

    // Полярні в Декартові
    public static double[] polarToCartesian(double r, double theta) {
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);
        return new double[]{x, y};
    }

    // Декартові в Полярні
    public static double[] cartesianToPolar(double x, double y) {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return new double[]{r, theta};
    }

    public static void main(String[] args) {
        // Задаємо полярні координати
        double r = 5;
        double theta = Math.toRadians(30); // В радіанах

        // Переводимо в декартові координати
        double[] cartesian = polarToCartesian(r, theta);
        System.out.printf("Декартові координати: x = %.2f, y = %.2f%n", cartesian[0], cartesian[1]);

        // Переводимо назад у полярні
        double[] polar = cartesianToPolar(cartesian[0], cartesian[1]);
        System.out.printf("Полярні координати: r = %.2f, θ = %.2f°%n", polar[0], Math.toDegrees(polar[1]));

        // Перевірка коректності
        System.out.println("Перевірка співпадання координат після зворотного перетворення:");
        System.out.printf("r: %.2f -> %.2f%n", r, polar[0]);
        System.out.printf("θ: %.2f -> %.2f%n", Math.toDegrees(theta), Math.toDegrees(polar[1]));
    }
}

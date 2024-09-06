package org.example;

public class CoordinateConverter3D {

    public static double[] sphericalToCartesian(double r, double theta, double phi) {
        double x = r * Math.sin(theta) * Math.cos(phi);
        double y = r * Math.sin(theta) * Math.sin(phi);
        double z = r * Math.cos(theta);
        return new double[]{x, y, z};
    }

    public static double[] cartesianToSpherical(double x, double y, double z) {
        double r = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.acos(z / r);
        double phi = Math.atan2(y, x);
        return new double[]{r, theta, phi};
    }

    public static void main(String[] args) {
        double r = 5;
        double theta = Math.toRadians(45);
        double phi = Math.toRadians(30);

        double[] cartesian = sphericalToCartesian(r, theta, phi);
        System.out.printf("Декартові координати: x = %.2f, y = %.2f, z = %.2f%n", cartesian[0], cartesian[1], cartesian[2]);

        double[] spherical = cartesianToSpherical(cartesian[0], cartesian[1], cartesian[2]);
        System.out.printf("Сферичні координати: r = %.2f, θ = %.2f°, φ = %.2f°%n", spherical[0], Math.toDegrees(spherical[1]), Math.toDegrees(spherical[2]));

        System.out.println("Перевірка співпадання координат після зворотного перетворення:");
        System.out.printf("r: %.2f -> %.2f%n", r, spherical[0]);
        System.out.printf("θ: %.2f -> %.2f%n", Math.toDegrees(theta), Math.toDegrees(spherical[1]));
        System.out.printf("φ: %.2f -> %.2f%n", Math.toDegrees(phi), Math.toDegrees(spherical[2]));
    }
}

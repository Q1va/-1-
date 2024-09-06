package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.Random;

public class Benchmark2D extends ApplicationFrame {

    public Benchmark2D(String title) {
        super(title);
    }


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


    private static JFreeChart createChart(XYSeriesCollection dataset) {
        return ChartFactory.createXYLineChart(
                "Benchmark Results",          // Назва графіка
                "Number of Points",           // Назва осі X
                "Execution Time (ms)",        // Назва осі Y
                dataset,                      // Дані для графіка
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }


    public static void main(String[] args) {

        XYSeries series = new XYSeries("Execution Time");


        for (int n = 1000; n <= 50000; n += 5000) {
            double time = benchmark(n);
            series.add(n, time);
            System.out.printf("Час виконання для %d точок: %.2f мс%n", n, time);
        }


        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);


        JFreeChart chart = createChart(dataset);
        Benchmark2D chartFrame = new Benchmark2D("Benchmark Results");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        chartFrame.setContentPane(chartPanel);

        chartFrame.pack();
        RefineryUtilities.centerFrameOnScreen(chartFrame);
        chartFrame.setVisible(true);
    }
}

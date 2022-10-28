package practice;

import java.awt.BasicStroke;

import org.knowm.xchart.*;

public class ComplexityVisual {

    static int linear(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    static int quadratic(int n) {
        int sumOfProducts = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumOfProducts += i * j;
            }
        }

        return sumOfProducts;
    }

    static int cubic(int n) {
        int sumOfProducts = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sumOfProducts += i * j * k;
                }
            }
        }

        return sumOfProducts;

    }

    static int exponential(int n) {
        if (n == 0 || n == 1) { // Base cases
            return 1;
        } else { // Recursive calls
            return exponential(n - 1) * exponential(n - 2);
        }

    }

    static void factorial(int n) {
        for (int i = 0; i < n; i++) {
            factorial(n - 1);
        }
    }

    static int logarithmic(int n) {
        int sum = 0;
        for (int i = n; i >= 1; i = i / 2) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        double[] nIterations = new double[50];

        for (int i = 0; i < nIterations.length; i++) {
            nIterations[i] = i + 1;
        }

        double[] linearTimes = new double[nIterations.length];
        for (int i = 0; i < nIterations.length; i++) {
            long start = System.nanoTime();
            linear(i);
            linearTimes[i] = System.nanoTime() - start;
        }

        double[] quadraticTimes = new double[nIterations.length];
        for (int i = 0; i < nIterations.length; i++) {
            long start = System.nanoTime();
            quadratic(i);
            quadraticTimes[i] = System.nanoTime() - start;
        }

        double[] cubicTimes = new double[nIterations.length];
        for (int i = 0; i < nIterations.length; i++) {
            long start = System.nanoTime();
            cubic(i);
            cubicTimes[i] = System.nanoTime() - start;
        }

        double[] exponentialTimes = new double[nIterations.length];
        for (int i = 0; i < nIterations.length; i++) {
            long start = System.nanoTime();
            exponential(i);
            exponentialTimes[i] = System.nanoTime() - start;
        }

        double[] factorialTimes = new double[nIterations.length];
        for (int i = 0; i < nIterations.length; i++) {
            long start = System.nanoTime();
            linear(i);
            factorialTimes[i] = System.nanoTime() - start;
        }

        double[] logarithmicTimes = new double[nIterations.length];
        for (int i = 0; i < nIterations.length; i++) {
            long start = System.nanoTime();
            linear(i);
            logarithmicTimes[i] = System.nanoTime() - start;
        }

        XYChart chart = QuickChart.getChart("Time Complexities",
                "nth Number", "Time taken (ns)", "linear", nIterations, linearTimes);

        chart.addSeries("quadratic", quadraticTimes)
                .setLineStyle(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        chart.addSeries("cubic", cubicTimes)
                .setLineStyle(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        chart.addSeries("exponential", exponentialTimes)
                .setLineStyle(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        chart.addSeries("factorial", factorialTimes)
                .setLineStyle(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        chart.addSeries("logarithmic", logarithmicTimes)
                .setLineStyle(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));

        new SwingWrapper<>(chart).displayChart();
    }
}

package practice;

import java.util.HashMap;

import org.knowm.xchart.*;

public class CompareFib {

    private static long fastFib(int n) {
        HashMap<Integer, Long> tracker = new HashMap<>(10000);
        tracker.put(Integer.valueOf(0), Long.valueOf(0));
        tracker.put(Integer.valueOf(1), Long.valueOf(1));
        return fastFib(n, tracker);
    }

    public static long fastFib(int n, HashMap<Integer, Long> map) {
        if (!map.containsKey(n)) {
            map.put(Integer.valueOf(n), Long.valueOf(fastFib(n - 1, map) + fastFib(n - 2, map)));
        }
        return map.get(n);
    }

    static long iterFib(int n) {
        int f0 = 0;
        int f1 = 1;
        int currentFib = 0;

        for (int i = 1; i < n; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }

        return currentFib;
    }

    static long recurFib(int n) {
        if (n == 0 || n == 1) { // Base cases
            return 1;
        } else { // Recursive calls
            return recurFib(n - 1) * recurFib(n - 2);
        }
    }

    public static void main(String[] args) {

        double[] iterations = new double[500];
        double[] fastTimes = new double[500];
        double[] iterTimes = new double[500];

        double[] recurIterations = new double[30];
        double[] recurTimes = new double[30];

        for (int i = 0; i < 500; i++) {
            long start = System.nanoTime();
            fastFib(i);
            long stop = System.nanoTime();
            double timeTaken = (double) (stop - start);
            iterations[i] = i;
            fastTimes[i] = timeTaken;
        }

        for (int i = 0; i < 500; i++) {
            long start = System.nanoTime();
            iterFib(i);
            long stop = System.nanoTime();
            double timeTaken = (double) (stop - start);
            iterTimes[i] = timeTaken;
        }

        for (int i = 0; i < 30; i++) {
            long start = System.nanoTime();
            recurFib(i);
            long stop = System.nanoTime();
            double timeTaken = (double) (stop - start);
            recurIterations[i] = i;
            recurTimes[i] = timeTaken;
        }

        // Create Charts
        XYChart chart1 = QuickChart.getChart("Fibonacci Algorithms: Fast",
                "nth Number", "Time taken (ns)", "y(x)", iterations, fastTimes);

        XYChart chart2 = QuickChart.getChart("Fibonacci Algorithms: Iterative",
                "nth Number", "Time taken (ns)", "y(x)", iterations, iterTimes);

        XYChart chart3 = QuickChart.getChart("Fibonacci Algorithms: Recursive",
                "nth Number", "Time taken (ns)", "y(x)", recurIterations, recurTimes);

        // Show it
        new SwingWrapper<>(chart1).displayChart();
        new SwingWrapper<>(chart2).displayChart();
        new SwingWrapper<>(chart3).displayChart();
    }
}

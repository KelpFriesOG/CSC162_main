package practice;

import java.util.HashMap;

import org.knowm.xchart.*;

public class BigO {

    static long linearAlgo(long n) {

        long start = System.nanoTime();
        int sum = 0;
        for (long i = 0; i < n; i++) {
            Math.round(Math.random());
        }
        long end = System.nanoTime();

        return (end - start);
    }

    static long quadraticAlgo(long n) {

        long start = System.nanoTime();

        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                Math.round(Math.random() * 1000);
            }
        }

        long end = System.nanoTime();

        return (end - start);
    }

    public static void main(String[] args) {

        double[] iterationN = new double[100000];
        double[] linearTimes = new double[100000];

        for (int i = 0; i < 50000; i++) {
            linearTimes[i] = linearAlgo(i);
            iterationN[i] = i;
        }

        XYChart chart1 = QuickChart.getChart("Linear Complexity",
                "nth Number", "Time taken (ns)", "y(x)", iterationN, linearTimes);

        new SwingWrapper<>(chart1).displayChart();

    }
}

package notes;

public class Chapter22 {
    /*
     * Chapter 22: Developing Efficent Algorithms
     * 
     * Goals:
     * - To estimate algorithm efficency using Big O notation.
     * - To explain growth rates and why constants and nondominating
     * terms can be ignored in the estimation.
     * - To determine the complexity of various types of algorithms.
     * - To analyze the binary search algorithms.
     * - To analyze the selection sort algorithm.
     * - To analyze the Tower of Hanoi algorithm.
     * - To describe common growth functions (constant, logarithimic,
     * log-linear, quadratic, cubic, and exponential).
     * - To design efficient algorithms for finding fibonacci numbers
     * using DYNAMIC PROGRAMMING (I have a love hate relationship with this one.)
     * - To find the GCD using Euclid's algorithm.
     * - To find prime numbers using the sieve of Eratosthenes (I <3 this).
     * - To design efficient algorithms for finding the closest pair of points
     * using the divide and conquer approach.
     * - To design efficient algorithms for finding a convex hull for a set
     * of points.
     * - I will ignore Eight Queens and KMP algos as they might be skipped.
     * (I sure hope so, because they are so damn annoying)
     * 
     * -------------------------------------------------------------------------
     * 
     * Why Use Big-O Notation? -------------------------------------------------
     * 
     * When comparing the speed of two programs there are two major hurdles
     * that bias our results.
     * 
     * 1) Computers multitask many programs on a computer, the actual execution
     * time depends on how many programs are running on the particular at a
     * given time, i.e. the system load.
     * 
     * 2) The actual execution time depends on a SPECIFIC input. If you have a
     * list and want to find a value which is the first element of the list,
     * a linear search WILL ALWAYS BE FASTER than a binary search.
     * But in general, Binary searches are faster! This is because the input
     * is hyper-specific and biased, but for a randomized input, we will
     * find the binary search to be quicker. In other words, if the input
     * is biased to favor a particular algorithm, it shows. SO WE NEED A
     * WAY TO QUANTIFY THE AVERAGE EFFICENCY OF A PROGRAM ON VARIOUS RANDOM
     * INPUTS OF VARYING LENGTH / SIZE.
     * 
     * So rather than comparing algorithms by measuring pure single comparisons
     * of speed,a theoretical approach of measuring a program's efficency was
     * constructed that was independent of the speed of a computer's hardware
     * or the size or distribution of an input. This is Big-O notation.
     * 
     * -------------------------------------------------------------------------
     * 
     * - An input that results in the shortest possible execution time is called
     * the BEST CASE input.
     * - An inputt that results in the longest possible execution time is called
     * the WORST CASE input.
     * 
     * An algorithm can never be slower than its worst case execution time,
     * therefore we tend to focus in on the Worst-case execution time when
     * talking about complexity.
     * 
     * Average case analysis may be the most ideal way to get a good idea
     * of the speed of an algorithm but is difficult to calculate
     * because for many problems determining the distribution of various input
     * instances is TEDIOUS and exceedingly complicated.
     * 
     * For linear search on list of length n:
     * Worst case: n comparisons to find element (last in list)
     * Best case: 1 comparison to find element (first in list)
     * Average case: n/2 comparisons to find element
     * 
     * For Big-O Notation the coefficent prior to the highest
     * power of n, and any lower powers of n can be ommited:
     * 
     * Worst case: O(n)
     * Best case: O(1)
     * Average case: O(n/2)
     * 
     * Algorithm analysis is for large input size. If the input size is small,
     * there is no significance in estimating an algorithm’s efficiency.
     * As n grows larger, the n part in the expression n - 1 dominates the
     * complexity. The Big O notation allows you to ignore the nondominating part
     * (e.g., -1 in the expression n - 1) and highlight the
     * important part (e.g., n in the expression n - 1).
     *
     * -------------------------------------------------------------------------
     *
     * Recall that while you can use inputs such as n = 10, n = 100, n = 1000,
     * and so forth to measure complexity of an algorithm, your results may vary
     * drastically from the hypothetical Big-O complexity. This is because
     * the JVM has many optimizations to enable it to skip processing where it can.
     * 
     * You can ensure that your code accurately represents a particular complexity
     * by using larger values of n, such as n = 1000000 vs n = 10000000 and
     * even larger inputs. Although this may take a lot of computation time,
     * rememeber that your algorithm should APPROACH the theoretical worst-case
     * complexity with larger values of n.
     * 
     * -------------------------------------------------------------------------
     * 
     * 
     * 
     */

    // #region Performance testing O(n) complexity

    static void getTime(long n) {

        long k = 0;

        long startTime = System.nanoTime();

        for (long i = 0; i <= n; i++) {
            k = k + 5;
            // k = k + Math.round(Math.random() * 10);
        }

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution time for n = " + n + " is " +
                executionTime + " nanoseconds");

    }

    // #endregion

    // #region Time Complexity examples

    static void example2(long n) {

        long num = 0;

        long startTime = System.nanoTime();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                num = num + i + j;
            }
        }

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Execution time for n = " + n + " is " +
                executionTime + " nanoseconds");

    }

    // #endregion

    public static void main(String[] args) {

        System.out.println("Initializing");
        System.nanoTime();
        getTime(1000000);
        getTime(1000000);
        // // Will take approximately 40ms
        getTime(10000000);
        // Will take approximately 300ms
        getTime(100000000);
        // Will take approximately 3000ms
        getTime(1000000000);
        // Will take approximately 30000ms

        // You can tell that the growth rate
        // of the function is n, because, if you
        // multiply the # of inputs by 10, the runtime also
        // gets 10x slower.

        // example2(100);
        // // Will take approximately 200000ns
        // example2(1000);
        // // Will take approximately 5240000ns
        // // Input size increased by 10x, speed slowed by 25x
        // example2(10000);
        // // Will take approximately 203150000ns
        // // Input size increased by 10x, speed slowed by 39x
        // example2(100000);
        // // Will take approximately 18946160000ns
        // // Input size increased by 10x, speed slowed by 93x

        // As you can see, as n gets larger we are approaching a
        // an quadratic (n^2) complexiety.

    }

}

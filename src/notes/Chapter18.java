package notes;

import java.util.Scanner;

public class Chapter18 {

    /*
     * Chapter 18: Recursion
     * 
     * Main Goals:
     * - To describe what a recursive method is and the benefits of using
     * recursion.
     * - To develop recursive method for recursive mathematical functions.
     * - To explain how recursive method calls are handled in a call stack. (I HATE
     * THIS ONE)
     * - To solve problems using recursion.
     * - To use an overloaded helper method to design a recursive method.
     * - To implement a selections sort using recursion.
     * - To implement a binary search using recursion.
     * - To get the directory size using recursion.
     * - To solve the Tower of Hanoi problem using recursion (also annoying).
     * - To draw fractals with recursion (we can try ignoring this one).
     * - To discover the relationship and difference between recursion
     * and iteration.
     * - To know tail recursive methods and why they are favorable.
     * 
     * -------------------------------------------------------------------------
     * 
     * Recursion is a technique that leads to elegant solutions to problems
     * that are diffucult to solve via traditional loops.
     * 
     * Instead of looping, we call the method from within the method,
     * which creates a recursive "stack" in the memory. When this stack
     * is fully evaluated or "popped" the program executes
     * from the inside out to give us our final answer.
     * 
     * In some cases recursion enables you to develop a natural,
     * straightforward, and simple solution to an otherwise diffucult
     * problem!
     * 
     * However, at first glance seeing the simplicity can be hard,
     * so you need to learn how to "think recursively".
     * 
     * ComputeFactorial.java ---------------------------------------------------
     * 
     * Consider the case of the computeFactorial program and
     * the definition of the mathematical factorial of a number.
     * 
     * 7! = 7 * 6 * 5 * 4 * 3 * 2 * 1
     * and
     * 6! = 6 * 5 * 4 * 3 * 2 * 1
     * 
     * Notice how 7! can be written as 7 * 6! factorial.
     * In fact I can go one step further and say
     * 7! = 7 * 6! = 7 * 6 * 5! ....
     * 
     * We can break down n! into n(n-1)! at each step which becomes
     * the foundation of our recursive function.
     * 
     * The first step is identifying the base case, or the
     * lowest possible value. Note that without a base case
     * the recursion of the method will recurse into infinity
     * maybe even crashing the program!
     * The base case acts as the base, the hard limit!
     * 
     * For factorials lets say its 0!, because 0! = 1
     * We know that if we ever get broken down so far as to computing
     * 0 factorial, we can just spit that value out, because
     * that will be the bare minimum.
     * 
     * Then we can implement n! = n(n-1)! by
     * saying factorial(n) should return n * factorial(n-1)
     * The compiler will then look at the second half (the factorial(n-1))
     * and break that down further by understanding that
     * factorial(n-1) returns (n-1)*factorial(n-2)
     * 
     * The problem will keep getting chunked RECURSIVELY since
     * each execution of the method will call an instance of itself
     * until we hit the base case.
     * 
     * When we hit the base case of n=0, there will be nothing
     * left to compute and the "stack" will pop
     * 
     * Ex.
     * If we put in n = 5
     * Then the series of actions
     * 1) Executed: factorial(5) = 5 * factorial(4)
     * 2) Executed: factorial(4) = 4 * factorial(3)
     * 3) Executed: factorial(3) = 3 * factorial(2)
     * 4) Executed: factorial(2) = 2 * factorial(1)
     * 5) Executed: factorial(1) = 1 * factorial(0)
     * 
     * Each of these executions builds up the stack which
     * you can just think of as memory inside the computer.
     * Intuitively this is because you need space to store
     * the results of each calculation.
     * 
     * Once we fill up the stack the compiler will begin
     * popping of elements from the top of the stack
     * it will simplify each element
     * 
     * 6) Simplify: factorial(1) = 1 * 1 {returns 1}
     * 7) Simplify: factorial(2) = 2 * (1 * 1) {returns 2}
     * 8) Simplify: factorial(3) = 3 * (2 * (1 * 1)) {returns 6}
     * ...
     * Until we get
     * 10) factorial(5) = 5 * 4 * 3 * 2 * 1 * 1 {returns 120 to "surface"}
     * 
     * ComputeFibonacci.java ---------------------------------------------------
     * 
     * Here are some of the first Fibonacci numbers:
     * 1, 1, 2, 3, 5, 8, 13
     * First ask yourself, can you get one fibonacci number
     * from the previous ones?
     * 
     * Notice
     * 2 = 1 + 1
     * 3 = 2 + 1
     * 5 = 3 + 2
     * 8 = 5 + 3
     * ...
     * 
     * Now given that the sequence starts from 2, how many base
     * cases do we have? in other words, how many numbers
     * did we skip to find the pattern?
     * 
     * WE HAVE 2 BASE CASES: n(0) = 1, n(1) = 1
     * and we have to keep track of the two previous numbers to
     * get any subsequent number
     * 
     * For x >= 2 (where 2 is the 3rd number, since n(0) is the beginning)
     * n(x) = n(x-1) + n(x-2)
     * 
     * How would we program this recursion? Look at the code sample!
     * How ould this function work?
     * 
     * Ex. Suppose we wanted the 5th fibonacci number:
     * fibonacci(5) = fibonacci(4) * fibonacci(3)
     * 
     * A)
     * this execution calls two calls two different calls-----------/
     * fibonacci(4) = fibonacci(3) + fibonacci(2)
     * fibonacci(3) = fibonacci(2) + fibonacci(1)
     * -------------------------------------------------------------/
     * 
     * B)
     * fibonacci(4) calls ------------------------------------------/
     * fibonacci(3) = fibonacci(2) + fibonacci(1)
     * fibonacci(2) = fibonacci(1) + fibonacci(0)
     * -------------------------------------------------------------/
     * 
     * fibonacci(3) calls ------------------------------------------/
     * fibonacci(2) = fibonacci(1) + fibonacci(0)
     * fibonacci(1) = 0
     * -------------------------------------------------------------/
     * 
     * C)
     * The fibonacci(3) from layer B's fibonacci(4) calls ----------/
     * fibonacci(2) = fibonacci(1) + fibonacci(0)
     * fibonacci(1) = 0
     * -------------------------------------------------------------/
     * 
     * The fibonacci(2) from layer B's fibonacci(4) calls-----------/
     * fibonacci(1) = 1
     * fibonacci(0) = 1
     * -------------------------------------------------------------/
     * 
     * The fibonacci(2) from layer B's fibonacci(3) calls-----------/
     * fibonacci(1) = 1
     * fibonacci(0) = 1
     * -------------------------------------------------------------/
     * 
     * D)
     * The fibonacci(2) from layer C's fibonacci(3) calls-----------/
     * fibonacci(1) = 1
     * fibonacci(0) = 1
     * -------------------------------------------------------------/
     * 
     * And now everything has been simplified to its base
     * case. When evaluating recusion with multiple base cases
     * and multiple recursive calls, it is always best to use
     * a tree to split one case into multiple and then split each
     * of the multiple cases into more recursive calls.
     * 
     * As a tree our understanding would look like:
     * 
     * ------------------------------fibonacci(5)---------------
     * ----------------------------/-------------\--------------
     * -------------------fibonacci(4)------------fibonacci(3)--
     * -----------------/-----------\------------/----------\---
     * ---------------f(3)---------f(2)---------f(2)-------f(1)-
     * --------------/----\-------/----\-------/----\-----------
     * -----------f(2)----f(1)--f(1)---f(0)--f(1)--f(0)---------
     * ----------/---\------------------------------------------
     * --------f(1)--f(0)---------------------------------------
     * 
     * Note how everything is simplified down to the base calls
     * 
     * each of these base calls then returns a value in
     * fact since adding can happen in any order if we add together
     * all the base calls...
     * f(1) + f(0) + f(1) + f(1) + f(0) + f(1) + f(0) + f(1) = 8
     * which is our correct answer!
     * 
     * After each execution is performed (we climb down the tree)
     * we pop the stack(return up from the base calls)!
     * Since in this particular example all base calls are added
     * together we know the answer is 8 just by looking at the
     * values of and number of base calls.
     * 
     * However the number of calls increases exponentially
     * as the tree grows
     * 
     * fib(2) requires 3 calls (1 for fib(3), 1 for fib(2) one for fib(1))
     * fib(5) required 15 calls
     * fib(20) would require an immense 21,891 calls
     * fib(50) would require around 2 billion calls. so uh
     * its not exactly fast nor is it memory efficent as
     * the numbers get a bit larger.
     * 
     * Thinking Recursively ----------------------------------------------------
     * 
     * So how do we try to figure out if something CAN or SHOULD be solved
     * recursively?
     * 
     * Well we know all recursive implementations have three characteristics
     * that go hand in hand
     * 
     * 1) A conditional statement that leads to different cases
     * 2) At least 1 base case that triggers to stop the recursion
     * 3) Every recursive call simplifies and reduces the size of the
     * original problem until that problem becomes a base case.
     * 
     * In general recursion is breaking down a complex problem into
     * smaller subproblems. The logical approach to solve each
     * subproblem should be identical and as simple as possible.
     * 
     * Recursive methods do not need to return a value,
     * they are stopped based on the value of one of their
     * parameters.
     * 
     * Ex. A recursive method to print out a message n amount of times
     * 
     * public static void nPrintln(String message, int times){
     * if(times >= 1){
     * System.out.println(message);
     * nPrintln(message, times - 1);
     * }
     * }
     * 
     * -------------------------------------------------------------------------
     * 
     * RecursivePalindromeUsingSubstring.java ----------------------------------
     * 
     * Base case: If the string has a length of 1 or 0, its always a palindrome!
     * Ex. "a", "1", "x" return true for this case!
     * 
     * Base case: If the first and last character are not the same, then we
     * know FOR A FACT that the entire string is not a palindrome!
     * Ex. "abc", a != c "12217", 1 != 7 return false for this case!
     * 
     * If we have not hit a base case then we go to our recursive case
     * We call the same method but on a smaller substring of the original string.
     * 
     * Ex. "abcca"
     * Call method, neither base case is hit so
     * 2) Call method on "bcc"
     * Base case 2 is hit, we stop and return false!
     * 
     * Ex. "abccba"
     * 1) Call method on "abccba" neither base case is hit
     * 2) Call method on "bccb" neither base case is hit
     * 3) Call method on "cc" neither base case is hit
     * 4) Call method on "c", first base case is hit, return true!
     * 
     * Now this way of checking is not the most efficent because a new string
     * needs to be created and passed at each recursive call.
     * To fix issues such as this, where the recursive call acts on a smaller
     * subset of the original input, we can make the use of helper
     * methods to improve memory and sometimes speed efficency.
     * 
     * RecursivePalindrome.java (with a helper method!)-------------------------
     * 
     * One way to use a helper method is to take in a parameter
     * and then splice or manipulate that paremeter before sending it to
     * the actual recursive call. That way the recursive method itself is not
     * working on new instances of a parameter in each call but rather on
     * different chunks of the parameter / piece of data.
     * 
     * Instead of having new strings made at each call we could have a helper
     * method which accepts a String and calls the recursive method using
     * the indexes of that passed String.
     * 
     * At each call, these indexes could be manipulated rather than the String
     * itself!
     * 
     * The role of the helper method in this case is to make the initial call
     * with the proper indexes instead of making the user specify the beginning
     * and endpoints of the String. In other words the helper method
     * ABSTRACTS the actual underlying implementation of the core method
     * by asking the user for the simple parameter and calculating
     * the more tedious parameters internally.
     * 
     * Recursive Selection Sort ------------------------------------------------
     * 
     * Now this gets into some data structures and algorithms thinking,
     * but hold with me here! I will try to avoid all the technical lingo
     * and just explain how this sorting technique works
     * 
     * Now first of all how does Selection Sort typically work?:
     * Selection sort takes a portion of the list, and finds the smallest
     * element. Then it swaps the position of the first element of the chunk
     * and the position of the minimum value. Afterwards, the same
     * sorting procedure is called on a smaller subsection of the array,
     * until the chunk you are working on is just one element.
     * 
     * Lets walk thorugh this with an example:
     * Suppose the list: [1, 12, 8, 64, 67, 54, 33, 82, 15]
     * SelectionSort is called with 3 parameters, the list, the lowIndex, and
     * the highIndex. Regardless of the list, the first call for selectionSort
     * will use 0 as the lowIndex and list.length-1 as the high index!
     * 
     * In this example we will assume the method takes the form:
     * selectionSort(list, lowIndex, highIndex);
     * 
     * Lets begin:
     * ^ will indicate the position of the low index,
     * + indicates the position of the high index
     * 
     * 1st call: selectionSort(list, 0, 8) // Our list has a length of 9
     * 1 12 8 64 67 54 33 82 15
     * ^ ------------------- +
     * We iterate throuth [low, high] and find that 1 is the low value,
     * we swap 1 with the element at the lowIndex, in this case
     * 1 is at the position of the lowIndex so it swaps with itself
     * i.e. nothing happens.
     * 
     * Then we call selectionSort but shift up the lowIndex by 1
     * 
     * 2nd call: selectionSort(list, 1, 8)
     * 1 12 8 64 67 54 33 82 15
     * - ^ ----------------- +
     * We iterate through [low, high] and find that 8 is the lowest value,
     * we swap the position of 8 with the position of the value of the low
     * pointer (we swap 12 with 8).
     * 
     * Now the array looks like:
     * 1 8 12 64 67 54 33 82 15
     * - ^ ----------------- +
     * 
     * Then we call selectionSort but shift up the lowIndex by 1
     * 
     * 3rd call: selectionSort(list, 2, 8)
     * 1 8 12 64 67 54 33 82 15
     * --- ^ --------------- +
     * We iterate through [low, high] and find that 12 is the lowest value,
     * we swap the position of 12 with the lowIndex. The lowIndex is at 12,
     * so our swapping really does nothing.
     * 
     * Then we call selectionSort but shift up the lowIndex by 1
     * 
     * 4th call: selectionSort(list, 3, 8)
     * 1 8 12 64 67 54 33 82 15
     * ------ ^ ------------ +
     * We iterate through [low, high] and find that 15 is the lowest value,
     * we swap the position of 15 and the value at the lowIndex.
     * 
     * Now the array looks like:
     * 1 8 12 15 67 54 33 82 64
     * ------ ^ ------------ +
     * 
     * Then we call selectionSort but shift up the lowIndex by 1
     * 
     * 5th call: selectionSort(list 4, 8)
     * 1 8 12 15 67 54 33 82 64
     * --------- ^ --------- +
     * 
     * Hopefully you know what should happen here so imma jump forward to
     * what the array would look like by the 8th call
     * 
     * 6th call:
     * 1 8 12 15 33 54 67 82 64
     * ------------ ^ ------ +
     * 
     * 7th call:
     * 1 8 12 15 33 54 67 82 64
     * --------------- ^ --- +
     * 
     * 8th call: selectionSort(list, 7, 8)
     * 1 8 12 15 33 54 64 82 67
     * ------------------ ^ -+
     * Now we are reaching the end here!
     * We only have to check one element against our lowIndex.
     * Swap the positions of the lowIndex and the minimum value!
     * 
     * Now the array looks like:
     * 1 8 12 15 33 54 64 67 82
     * ------------------ ^ -+
     * 
     * 9th call: selectionSort(list, 8, 8)
     * 1 8 12 15 33 54 64 67 82
     * --------------------- +
     * --------------------- ^
     * We know that if (lowIndex < highIndex) is not true
     * we have reached the base case and can stop recursion!
     * 
     * To determine if you truly understand what happened:
     * 1) What simple change could you make to the code to order in
     * descending order instead of in ascending order?
     * 2) For a list of n elements, how many times is selectionSort called?
     * 3) How could you further optimize this (hint: think of what parameters
     * we used vs which we did not)
     * 
     * Recursive Binary Search -------------------------------------------------
     * For a recursive binary search, the input list should be sorted in
     * ascending order ( we could use the selectionSort algo to do this if we
     * wanted to! ).
     * 
     * 
     * 
     * 
     * -------------------------------------------------------------------------
     * 
     */

    // #region Simple Numerical Recursion Applications

    static int computeFactorial(int n) {
        if (n == 0) { // Base case
            return 1;
        } else { // Recursive call
            return n * computeFactorial(n - 1);
        }

        // Suppose n = 5
        /*
         * Then at the first level of recursion:
         * 5 * factorial(4) is called.
         * then..
         * factorial(4) = 4 * factorial(3)
         * factorial(3) = 3 * factorial(2)
         * factorial(2) = 2 * factorial(1)
         * factorial(1) = 1 * faactorial(0)
         * factorial(0) = 1 {BASE CASE}
         * 
         * This is how you think recursively,
         * you break down until you get to the base case
         * and then use the base case to build back up.
         * 
         * Now if we simplify this all out:
         * factorial(5) = 5 * (4 * (3 * (2 * (1 * 1))))
         * factorial(5) = 5 * 4 * 3 * 2 * 1 * 1
         * = 120
         * 
         */

    }

    static int computeFibonacci(int index) {
        if (index == 0 || index == 1) { // Base cases
            return 1;
        } else { // Recursive calls
            return computeFactorial(index - 1) * computeFactorial(index - 2);
        }
    }

    // #endregion

    // #region Recursion on void methods

    static void printNTimes(String message, int times) {
        if (times >= 1) {
            System.out.println(message);
            printNTimes(message, times - 1);
        }
        // Base case occurs when times == 0
    }

    // #endregion

    // #region Checking for palindromes

    static boolean checkPalindrome(String s) {
        if (s.length() <= 1) { // Base case
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) { // Base case
            return false;
        } else { // Recursive case
            return checkPalindrome(s.substring(1, s.length() - 1));
        }
    }

    // #endregion

    // #region Optimized Palindrome checking methods

    // Helper method
    static boolean checkPalindromeOptimized(String s) {
        return checkPalindromeOptimized(s, 0, s.length() - 1);
    }

    // Note that while the private keyword does not do anything here,
    // ideally if this method was in another class, the user
    // should not be able to call this method, and should only
    // be able to trigger this method via the abstraction of the
    // helper method to avoid confusion!
    // That is why I used private modifier just to show best practice
    // of hiding the method the helper method calls to.
    private static boolean checkPalindromeOptimized(String s, int low, int high) {
        if (s.length() <= 1) { // Base case
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) { // Base case
            return false;
        } else { // Recursive case
            return checkPalindromeOptimized(s, low + 1, high - 1);
        }
    }

    // #endregion

    // #region Recursive Selection Sort

    static void selectionSort(double[] list) {
        selectionSort(list, 0, list.length - 1);
    }

    private static void selectionSort(double[] list, int low, int high) {
        if (low < high) {
            // Find the smallest number and its index in list[low .. high]

            int minPointer = low; // index of min
            double min = list[minPointer];

            for (int i = low + 1; i <= high; i++) {
                if (list[i] >= min) {
                } else {
                    min = list[i];
                    minPointer = i;
                }
            }

            // Swap the smallest element in the list with the list[low] = value
            list[minPointer] = list[low];
            list[low] = min;

            // Sort the rest of the list from [low+1, high]
            // Notice that this recursive call operates on a shrinking array
            selectionSort(list, low + 1, high);

        }
        // The base case occurs when low == high, in which case the array is sorted!

    }

    // #endregion

    // #region Recursive Binary Search

    public static int binarySearch(double[] list, double key) {
        return binarySearch(list, key, 0, list.length - 1);
    }

    private static int binarySearch(double[] list, double key, int low, int high) {

        if (low > high) {
            return -low - 1;
        }

        int mid = (low + high) / 2;

        if (key < list[mid]) {
            // If key is less than the mid value, search the lower half
            return binarySearch(list, key, 0, mid - 1);
        } else if (key > list[mid]) {
            // If key is greater than the mid value, search upper half
            return binarySearch(list, key, mid + 1, high);
        } else {
            // Otherwise the key must equal mid, so SUCCESS!
            // return the location of the mid index
            return mid;
        }

    }

    // #endregion

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    }
}

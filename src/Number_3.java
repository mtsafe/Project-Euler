// Project Euler #3: Largest prime factor
/*
PROBLEM:
The prime factors of 13195 are 5, 7, 13, and 29.

What is the largest prime factor of a given number N?

INPUT FORMAT
First line contains T, the number of test cases. This is
followed by T lines each containing an integer N.

CONSTRAINTS
1 <= T <= 10
10 <= N <= 1E12

OUTPUT FORMAT
For each test case, display the largest prime factor of N.

PERSONAL NOTE
99999999997 This number takes a long time to get
5882352941  this factor.
*/

import java.util.Scanner;

public class Number_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long start;
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            start = System.currentTimeMillis();
            System.out.println(largestPrimeFactor(n));
            elapsedTime(start, System.currentTimeMillis());
            start = System.currentTimeMillis();
            System.out.println(largestPrimeFactor1(n));
            elapsedTime(start, System.currentTimeMillis());
        }
    }

    public static void elapsedTime(long start, long stop) {
        float sec = (stop - start) / 1000F;
        System.out.println("Elapsed time: " + sec + " seconds");
    }

    public static long largestPrimeFactor(long n) {
        long product = n;
        long maxFactor = 1;
        long testFactor = 1;
        product = maxOddFactor(product);
        if (product == 1) return 2;
        // if (isOddPrime(product)) return product;
        while (product > 1) {
            if (maxFactor > Math.sqrt(product)) return product;
            testFactor += 2;
            while (product % testFactor == 0) {
                product /= testFactor;
                maxFactor = testFactor;
            }
        }
        return maxFactor;
    }

    public static long largestPrimeFactor1(long n) {
        long product = n;
        long maxFactor = 1;
        long testFactor = 1;
        product = maxOddFactor(product);
        if (product == 1) return 2;
        if (isOddPrime(product)) return product;
        while (product > 1) {
            testFactor = nextPrime(testFactor);
            while (product % testFactor == 0) {
                product /= testFactor;
                maxFactor = testFactor;
            }
        }
        return maxFactor;
    }

    public static long maxOddFactor(long product) {
        long result = product;
        while (result % 2 == 0) result /= 2;
        return result;
    }

    public static long nextPrime(long prime) {
        if (prime < 3) return (prime + 1);
        long testN = prime + 2;
        while (!isOddPrime(testN)) {
            testN += 2;
        }
        return testN;
    }

    public static boolean isOddPrime(long odd) {
        long testFactor = 3;
        while (testFactor <= Math.sqrt(odd)) {
            if (odd % testFactor == 0) return false;
            testFactor += 2;
        }
        return true;
    }
}

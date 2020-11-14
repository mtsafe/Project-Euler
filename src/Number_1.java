// Project Euler #1: Multiples of 3 and 5
/*
PROBLEM:
If we list all the natural numbers below 10 that are multiples
of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below N.

INPUT FORMAT:
First line contains T that denotes the number of test cases.
This is followed by T lines, each containing an integer, N.

CONSTRAINTS
1 <= T <= 1E5
1 <= N <= 1E9

OUTPUT FORMAT
For each test case, print an integer that denotes the sum of all
the multiples of 3 or 5 below N.
*/


import java.util.Scanner;

public class Number_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int n_1 = n - 1;
            long sum = 0;
            sum += sumOfMultiples(n_1, 3);
            sum += sumOfMultiples(n_1, 5);
            sum -= sumOfMultiples(n_1, 15);

            System.out.println(sum);
        }
    }

    public static long sumOfMultiples(int n, int factor) {
        if (n < factor) return 0;
        int numberOfMultiples = n / factor;
        long maxMultiple = factor * numberOfMultiples;
        return (numberOfMultiples + 1) * maxMultiple  / 2;
    }
}
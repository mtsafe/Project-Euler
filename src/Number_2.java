// Project Euler #2: Even Fibonacci numbers
/*
PROBLEM:
Each new term in the Fibonacci sequence is generated by adding the
previous two terms. By starting with 1 and 2, the first 10 terms
will be:
1, 2, 3, 5, 8, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values
do not exceed N, find the sum of the even-valued terms.

INPUT FORMAT
First line contains T that denotes the number of test cases. This
is followed by T lines, each containing an integer N.

CONSTRAINTS
1 <= T <= 1E5
10 <= N <= 4E16

OUTPUT FORMAT
Print the required answer for each test case.
*/

import java.util.Scanner;

public class Number_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(evenFibonacciSum(n));
        }
    }
    public static long evenFibonacciSum(long n) {
        long sum = 0;
        long aTmp;
        for (long a0 = 1, a1 = 2; a1 < n; aTmp=a1, a1+=a0, a0=aTmp) {
            if (a1 % 2 == 0) sum += a1;
        }
        return sum;
    }
}

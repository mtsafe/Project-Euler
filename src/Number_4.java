import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int pal = nextPalindrome(n);
            while (!isProduct(pal)) {
                pal--;
                pal = nextPalindrome(pal);
            }
            System.out.println(pal);
        }
    }

    static Pattern palPattern = Pattern.compile(
            "(\\d)(\\d)(\\d)(\\3)(\\2)(\\1)"
    );

    static int nextPalindrome(int n) {
        System.err.println("nextPalindrome " + n);
        for (int next = n; next >= 101101; next--) {
            Matcher palMatcher = palPattern.matcher(
                    Integer.toString(next));
            if (palMatcher.find()) return next;
        }
        return 0;
    }

    // Array of prime numbers
    static int primeArraySize = 30;
    static int[] primeArray = new int[primeArraySize];
    static int maxPrimeIndx;

    static {
        primeArray[0] = 2;
        for (maxPrimeIndx = 1; maxPrimeIndx < primeArraySize; maxPrimeIndx++) {
            primeArray[maxPrimeIndx] = (int) nextPrime(
                    primeArray[maxPrimeIndx - 1]);
        }
        System.err.println("primeArray "+Arrays.toString(primeArray));
    }

    static int nextPrime(int prime) {
        for (int primeIndx = 1; primeIndx < primeArraySize; primeIndx++) {
            if (primeArray[primeIndx] == prime)
                return primeArray[primeIndx + 1];
        }
        return (-1);
    }
    // END Array of prime numbers

    // Array of prime factors
    // factorArray[0] = the number of factors in the array;
    static int[] primeFactorization(int num) {
        System.err.println("primeFactorization " + num);
        int product = num;
        int[] factorArray = new int[primeArraySize + 1];
        int factorIndx = 1;
        factorArray[0] = 0;
        for (int primeIndx = 0; primeIndx < primeArraySize; primeIndx++) {
            while (product % primeArray[primeIndx] == 0) {
                System.err.print(product + " " +
                        factorArray[factorIndx] + " " +
                        primeArray[primeIndx] + " ");
                factorArray[factorIndx] = primeArray[primeIndx];
                product /= factorArray[factorIndx];
                factorArray[0] = factorIndx++;
                System.err.println(product);
            }
        }
        System.err.println("return factors");
        return factorArray;
    }

    // END Array of prime factors
    static boolean is3Digit(int num) {
        return num >= 100 && num < 1000;
    }

    static boolean winningCombo(int[] fArray, long fBits) {
        System.err.println("winningCombo " +
                Arrays.toString(fArray) + " : " + fBits);
        int factorA = 1, factorB = 1;
        int numFactors = fArray[0];
        long fAMask = 1;
        for (int fAIndx = 0; fAIndx < numFactors; fAIndx++) {
            if ((fBits & fAMask) == 1)
                factorA *= fArray[fAIndx];
            else
                factorB *= fArray[fAIndx];
            fAMask <<= 1;
        }
        System.err.println("return "+factorA+" "+factorB);
        System.err.println("return "+is3Digit(factorA)+" "+is3Digit(factorB));
        return is3Digit(factorA) && is3Digit(factorB);
    }

    static boolean isProduct(int pal6) {
        int[] factorArray = primeFactorization(pal6);
        int numFactors = factorArray[0];
        for (long factorBits = 1; factorBits <= numFactors; factorBits++) {
            if (winningCombo(factorArray, factorBits))
                return true;
        }
        return false;
    }

    static boolean isProduct1(int pal6) {
        int evenness = pal6 % 2 == 0 ? 2 : 1;
        int thirdness = pal6 % 3 == 0 ? 3 : 1;
        int fifthness = pal6 % 5 == 0 ? 5 : 1;
        int ness = evenness * thirdness * fifthness;
        int start;
        int stop = (int) Math.sqrt(pal6);
        if (evenness == 2)
            if (thirdness == 3)
                if (fifthness == 5)
                    start = 120;
                else
                    start = 102;
            else if (fifthness == 5)
                start = 100;
            else
                start = 102;
        else if (thirdness == 3)
            if (fifthness == 5)
                start = 105;
            else
                start = 111;
        else if (fifthness == 5)
            start = 115;
        else {
            ness = 2;
            start = 101;
        }
        for (int factor = start; factor < stop; factor += ness) {
            System.err.println(pal6 + " " + factor + " " + ness);
            if (pal6 % factor == 0)
                return true;
        }
        return false;
    }
}

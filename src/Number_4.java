// Project Euler #4: Largest palindrome product

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number_4 {
    static boolean isErrLogOn = true;

    static void errLog(String str) {
        if (isErrLogOn) {
            System.err.println(str);
        }
    }
    public static String toString(String[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        for (int i = 0; i <= iMax; i++) {
            b.append(a[i]);
            b.append("\n");
        }
        return b.toString();
    }

    public static void main(String[] args) {
        Scanner in = args == null ?
                new Scanner(System.in) :
                new Scanner(toString(args));
//        Scanner in = new Scanner(String.valueOf(args));
//        Scanner in = new Scanner(System.in);
//        String tFoo = in.next();
//        errLog("args is '"+tFoo+"'");
        int t = Integer.parseInt(in.next());
        for (int a0 = 0; a0 < t; a0++) {
            int n = Integer.parseInt(in.next());
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
        errLog("nextPalindrome " + n);
        for (int next = n; next >= 101101; next--) {
            Matcher palMatcher = palPattern.matcher(
                    Integer.toString(next));
            if (palMatcher.find()) return next;
        }
        return 0;
    }

    static boolean isProduct(int pal6) {
        int[] factorArray = primeFactorization(pal6);
        int numFactors = factorArray[0];
        for (long factorBits = 1; factorBits <= numFactors; factorBits++) {
            if (isWinningCombo(factorArray, factorBits))
                return true;
        }
        return false;
    }

    // Array of prime numbers
    static int primeCacheSize = 200;
    static int[] primeCache = new int[primeCacheSize];
    static int maxPrimeIndx;

    // primeCache[] should look like {2, 3, 5, 7, ...}
    static {
        errLog("BEGIN: primeCache initialization");
        primeCache[0] = 2;
        primeCache[1] = 3;
        primeCache[2] = 5;
        maxPrimeIndx = 2;
        for (int primeIndx = maxPrimeIndx + 1;
             primeIndx < primeCacheSize;
             primeIndx++, maxPrimeIndx++) {
            errLog("LOOP: primeIndx: " + primeIndx +
                    " < " + primeCacheSize + " :primeCacheSize");
            errLog("primeCache " + Arrays.toString(primeCache));
            errLog(
                    "ASSIGN: primeCache[" + primeIndx + "] = (int) nextPrime(" +
                            "primeCache[" + primeIndx + " - 1])");
            primeCache[primeIndx] = (int) nextPrime(
                    primeCache[primeIndx - 1]);
            if (primeCache[primeIndx] <= primeCache[primeIndx - 1]) {
                errLog("Bad Sequence");
                break;
            }
        }
        errLog("primeCache " + Arrays.toString(primeCache));
        errLog("END: primeCache initialization");
    }

    // Given a prime number "prime" return the next prime number
    static int nextPrime(int prime) {
        errLog("nextPrime(" + prime + ")");
//        if (prime < 2) return 2;
        // First check the global array
        int primeIndx = 0;
        for (; primeIndx < maxPrimeIndx; primeIndx++) {
            if (primeCache[primeIndx] > prime)
                return primeCache[primeIndx];
            if (primeCache[primeIndx] == prime)
                return primeCache[primeIndx + 1];
        }
        // At this point the array is of no use.
        // Continuing from that last prime in the global array
        // use calculations to find the next prime number
//        errLog("primeIndx < maxPrimeIndx : " +
//                primeIndx + "<" + maxPrimeIndx);
//        for (; primeIndx < primeCacheSize; primeIndx++, maxPrimeIndx++) {
        errLog("Initialize Loop nextNum = primeCache[" + primeIndx + "]");
        int nextNum = primeCache[primeIndx] + 2;
        for (; !isOddPrime(nextNum); nextNum += 2) {
            errLog("LoopCondition !isOddPrime(" + nextNum + ")");
//            if (nextNum > 30) return (-1);
        }
        return (nextNum);
    }
    // END Array of prime numbers

    // Test for isOddPrime
    static boolean isOddPrime(int oddNum) {
        if (oddNum % 2 == 0) return false;
        int odd = oddNum;
        for (int divisor = 3; divisor <= Math.sqrt(odd); divisor++) {
            if (odd % divisor == 0) return false;
        }
        return true;
    }
    // END Test for isOddPrime

    // Array of prime factors
    // factorArray[0] = the number of factors in the array;
    static int[] primeFactorization(int num) {
        errLog("primeFactorization " + num);
        int product = num;
        int[] factorArray = new int[primeCacheSize + 1];
        int factorIndx = 1;
        factorArray[0] = 0;
        int testPrime = 0;
        for (int primeIndx = 0; primeIndx < primeCacheSize; primeIndx++) {
            testPrime = nextPrime(testPrime);
            while (product % testPrime == 0) {
                errLog(product + " " +
                        factorArray[factorIndx] + " " +
                        testPrime + " ");
                factorArray[factorIndx] = testPrime;
                product /= factorArray[factorIndx];
                factorArray[0] = factorIndx++;
                errLog(Integer.toString(product));
                if (product == 1)
                    return shortenArray(factorArray);
            }
        }
        errLog("return factors");
        return shortenArray(factorArray);
    }

    static int[] shortenArray(int[] arr) {
        int newLength = arr[0] + 1;
        int[] returnArray = new int[newLength];
        for (int indx=0; indx<newLength; indx++) {
            returnArray[indx] = arr[indx];
        }
        return returnArray;
    }

    // END Array of prime factors
    static boolean is3Digit(int num) {
        return num >= 100 && num < 1000;
    }


    static boolean isWinningCombo(int[] fArray, long fBits) {
        errLog("winningCombo " +
                Arrays.toString(fArray) + " : " + fBits);
        int factorA = 1, factorB = 1;
        int numFactors = fArray[0];
        long fAMask = 1;
        for (int fAIndx = 1; fAIndx <= numFactors; fAIndx++) {
            errLog("LOOP "+fAIndx+" "+fAMask+" "+numFactors);
            if ((fBits & fAMask) == 0)
                factorA *= fArray[fAIndx];
            else
                factorB *= fArray[fAIndx];
            fAMask <<= 1;
            errLog("END LOOP " + factorA + " " + factorB);
        }
        errLog("return " + factorA + " " + factorB);
        errLog("return " + is3Digit(factorA) + " " + is3Digit(factorB));
        return is3Digit(factorA) && is3Digit(factorB);
    }
/*
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
            errLog(pal6 + " " + factor + " " + ness);
            if (pal6 % factor == 0)
                return true;
        }
        return false;
    }
 */
}

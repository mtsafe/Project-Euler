package tech.tarsha.math.algos;

public class Prime {
    /*
        method nextPrime(): returns long
        parameters: long prime
        Given a prime number "prime", the next prime number is returned.
        Note: the first actual prime number is 2.
     */
    public static long nextPrime(long prime) {
        if (prime < 2) return (2);
        if (prime == 2 ) return (3);
        long testN = prime + (prime % 2 == 0 ? 1 : 2);
        while (!isOddPrime(testN)) {
            testN += 2;
        }
        return testN;
    }
    /*
        method isOddPrime(): returns boolean
        parameters: long odd
        Given a positive odd number, it tests if "odd" is prime.
     */
    public static boolean isOddPrime(long odd) {
        long testFactor = 3;
        while (testFactor <= Math.sqrt(odd)) {
            if (odd % testFactor == 0) return false;
            testFactor += 2;
        }
        return true;
    }
}

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Number_4Test {

    @Test
    void errLog() {
        String parms = new String("foo");
        Number_4.errLog(parms);
        assertSame(parms, parms);
    }

    @Test
    void main() {
        String []args = {"1", "101110"};
        Number_4.main(args);
        assertArrayEquals(args, args);
    }

    @Test
    void nextPalindrome_101110_101101() {
        int actual = Number_4.nextPalindrome(101110);
        assertEquals(101101, actual);
    }

    @Test
    void nextPrime_2_3() {
        int actual = Number_4.nextPrime(2);
        assertEquals(3, actual);
    }

    @Test
    void nextPrime_3_5() {
        int actual = Number_4.nextPrime(3);
        assertEquals(5, actual);
    }

    @Test
    void nextPrime_5_7() {
        int actual = Number_4.nextPrime(5);
        assertEquals(7, actual);
    }

    @Test
    void nextPrime_7_11() {
        int actual = Number_4.nextPrime(7);
        assertEquals(11, actual);
    }

    @Test
    void nextPrime_11_13() {
        int actual = Number_4.nextPrime(11);
        assertEquals(13, actual);
    }

    @Test
    void nextPrime_0_2() {
        int actual = Number_4.nextPrime(0);
        assertEquals(2, actual);
    }

    @Test
    void nextPrime_N1_2() {
        int actual = Number_4.nextPrime(-1);
        assertEquals(2, actual);
    }

    @Test
    void nextPrime_N2_2() {
        int actual = Number_4.nextPrime(-2);
        assertEquals(2, actual);
    }

    @Test
    void isOddPrime_3_True() {
        boolean actual = Number_4.isOddPrime(3);
        assertTrue(actual);
    }

    @Test
    void isOddPrime_5_True() {
        boolean actual = Number_4.isOddPrime(5);
        assertTrue(actual);
    }

    @Test
    void isOddPrime_7_True() {
        boolean actual = Number_4.isOddPrime(7);
        assertTrue(actual);
    }

    @Test
    void isOddPrime_2_False() {
        boolean actual = Number_4.isOddPrime(2);
        assertFalse(actual);
    }

    @Test
    void isOddPrime_N2_False() {
        boolean actual = Number_4.isOddPrime(-2);
        assertFalse(actual);
    }

    @Test
    void primeFactorization_101101() {
        int[] actual = Number_4.primeFactorization(101101);
        int[] expected = {4, 7, 11, 13, 101 };
        System.err.println("Comparing expected: "+ Arrays.toString(expected)+
                "\nTo actual: "+Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    void is3Digit_123_True() {
        boolean actual = Number_4.is3Digit(123);
        assertTrue(actual);
    }
    @Test
    void is3Digit_1234_False() {
        boolean actual = Number_4.is3Digit(1234);
        assertFalse(actual);
    }
    @Test
    void is3Digit_999_True() {
        boolean actual = Number_4.is3Digit(999);
        assertTrue(actual);
    }
    @Test
    void is3Digit_99_False() {
        boolean actual = Number_4.is3Digit(99);
        assertFalse(actual);
    }

    @Test
    void isWinningCombo_2GoodFactors_True() {
        int[] factorArray = {2, 101, 456 };
        long factorBits = 1;
        boolean actual = Number_4.isWinningCombo(factorArray, factorBits);
        assertTrue(actual);
    }

    @Test
    void isWinningCombo_GoodFactors_True() {
        int[] factorArray = {4, 7, 11, 13, 101 };
        long factorBits = 9;
        boolean actual = Number_4.isWinningCombo(factorArray, factorBits);
        assertTrue(actual);
    }

    @Test
    void isWinningCombo_BadFactors_False() {
        int[] factorArray = {3, 7, 13, 101 };
        long factorBits = 9;
        boolean actual = Number_4.isWinningCombo(factorArray, factorBits);
        assertFalse(actual);
    }

    @Test
    void isWinningCombo_BadBits_False() {
        int[] factorArray = {4, 7, 11, 13, 101 };
        long factorBits = 13;
        boolean actual = Number_4.isWinningCombo(factorArray, factorBits);
        assertFalse(actual);
    }

    @Test
    void isProduct() {
    }
/*
    @Test
    void isProduct1() {
    }
*/
}
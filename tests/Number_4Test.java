import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Number_4Test {

    @Test
    void main() {
    }

    @Test
    void nextPalindrome() {
    }

    @Test
    void next2Prime3() {
        int actual = Number_4.nextPrime(2);
        assertEquals(3, actual);
    }

    @Test
    void primeFactorization() {
    }

    @Test
    void is3Digit123True() {
        boolean actual = Number_4.is3Digit(123);
        assertTrue(actual);
    }
    @Test
    void is3Digit1234False() {
        boolean actual = Number_4.is3Digit(1234);
        assertFalse(actual);
    }
    @Test
    void is3Digit999True() {
        boolean actual = Number_4.is3Digit(999);
        assertTrue(actual);
    }
    @Test
    void is3Digit99False() {
        boolean actual = Number_4.is3Digit(99);
        assertFalse(actual);
    }

    @Test
    void winningCombo() {
    }

    @Test
    void isProduct() {
    }

    @Test
    void isProduct1() {
    }
}
package tech.tarsha.math.algos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    public void next2Prime3() {
        long actual = Prime.nextPrime(2L);
        assertEquals(3L, actual);
    }
    @Test
    public void next3Prime5() {
        long actual = Prime.nextPrime(3L);
        assertEquals(5L, actual);
    }
    @Test
    public void next5Prime7() {
        long actual = Prime.nextPrime(5L);
        assertEquals(7L, actual);
    }
    @Test
    public void next7Prime11() {
        long actual = Prime.nextPrime(7L);
        assertEquals(11L, actual);
    }
    @Test
    public void next11Prime13() {
        long actual = Prime.nextPrime(11L);
        assertEquals(13L, actual);
    }
    @Test
    public void next13Prime17() {
        long actual = Prime.nextPrime(13L);
        assertEquals(17L, actual);
    }
    @Test
    public void next1Prime2() {
        long actual = Prime.nextPrime(1L);
        assertEquals(2L, actual);
    }
    @Test
    public void next0Prime2() {
        long actual = Prime.nextPrime(0L);
        assertEquals(2L, actual);
    }
    @Test
    public void nextN1Prime2() {
        long actual = Prime.nextPrime(-1L);
        assertEquals(2L, actual);
    }
    @Test
    public void next103Prime107() {
        long actual = Prime.nextPrime(103L);
        assertEquals(107L, actual);
    }
    @Test
    public void next104Prime107() {
        long actual = Prime.nextPrime(104L);
        assertEquals(107L, actual);
    }
    @Test
    public void next32558Prime32561() {
        long actual = Prime.nextPrime(32558L);
        assertEquals(32561L, actual);
    }
    @Test
    public void is3Prime() {
        boolean actual = Prime.isOddPrime(3);
        assertTrue(actual);
    }
    @Test
    public void is5Prime() {
        boolean actual = Prime.isOddPrime(5);
        assertTrue(actual);
    }
    @Test
    public void is7Prime() {
        boolean actual = Prime.isOddPrime(7);
        assertTrue(actual);
    }
    @Test
    public void is9Prime() {
        boolean actual = Prime.isOddPrime(9);
        assertFalse(actual);
    }
    @Test
    public void is11Prime() {
        boolean actual = Prime.isOddPrime(11);
        assertTrue(actual);
    }
    @Test
    public void is13Prime() {
        boolean actual = Prime.isOddPrime(13);
        assertTrue(actual);
    }
    @Test
    public void is15Prime() {
        boolean actual = Prime.isOddPrime(15);
        assertFalse(actual);
    }
    @Test
    public void is999999989Prime() {
        boolean actual = Prime.isOddPrime(999999989);
        assertFalse(actual);
    }
    @Test
    public void is999999997Prime() {
        boolean actual = Prime.isOddPrime(999999997);
        assertFalse(actual);
    }
}
package tech.tarsha.test;
/*
This is based on code from Antonio Vinicius Menezes Medei
on StackOverflow.com
https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing/1648989#1648989
 */

// import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

// import static org.junit.jupiter.api.Assertions.*;

// import static org.junit.Assert.*;
// import java.io.*;
// import org.junit.*;

public class wrapperForMainStdIO {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
/*
    // Sample test case
    @Test
    public void testCase1() {
        final String testString = "Hello!";
        provideInput(testString);

        mainProgram.main(new String[0]);

        assertEquals(testString, getOutput());
    }
 */
}
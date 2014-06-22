import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MathOpTest {
    private MathOp a;


    @Before
    public void setUp() throws IOException {

        a = new MathOp();
        }


    @Test
    public void testPos() {
        String data = "3";
        a.setScanner(new Scanner(data));
        assertEquals(6, a.fac());
    }

    @Test
    public void testNeg() {
        String data = "-3";
        a.setScanner(new Scanner(data));
        assertEquals(6, a.fac());
    }

    @Test
    public void testOv() {
        String data = "32";
        a.setScanner(new Scanner(data));
        assertEquals(6, a.fac());
    }

    @Test
    public void testNull() {
        String data = "0";
        a.setScanner(new Scanner(data));
        assertEquals(1, a.fac());
    }

    @Test
    public void testDot() {
        String data = "1,2";
        a.setScanner(new Scanner(data));
        assertEquals(6, a.fac());
    }

    @Test
    public void testChar() {
        String data = "e";
        a.setScanner(new Scanner(data));
        assertEquals(6, a.fac());
    }

    @Test
    public void testIn() {
        a.setScanner(new Scanner(System.in));
        assertEquals(6, a.fac());
    }

}

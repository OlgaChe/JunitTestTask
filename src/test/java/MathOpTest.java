import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathOpTest {
    private MathOp a;

    @Before
    public void setUp(){
        a = new MathOp();
    }

    @Test
    public void testFac() {
        MathOp a = new MathOp();
        assertEquals(6, a.fac(3));
    }

}
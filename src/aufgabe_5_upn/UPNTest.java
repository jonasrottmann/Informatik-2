package aufgabe_5_upn;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UPNTest extends TestCase {

    @Test
    public void testCalc1() throws Exception {
        UPN upn = new UPN("15 42 18 + 61 24 - * 71 + *");
        assertEquals(34365, upn.calc());
    }

    @Test
    public void testCalc2() throws Exception {
        UPN upn = new UPN("24 1 +");
        assertEquals(25, upn.calc());
    }

    @Test
    public void testCalc3() throws Exception {
        UPN upn = new UPN("3 1 2 + *");
        assertEquals(9, upn.calc());
    }
}
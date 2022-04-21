import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {
    @org.junit.jupiter.api.Test
    void replaceVariable() {
        ExpressionParser temp = new ExpressionParser();
        temp.replaceVariable("pi", 3.0);
        assertEquals(3.0, temp.getVariable("pi"));
    }

    @org.junit.jupiter.api.Test
    void getVariable() {
        ExpressionParser temp = new ExpressionParser();
        assertEquals(Math.PI, temp.getVariable("pi"));

        double b = 2.9;
        temp.setVariable("b", b);
        assertEquals(b, temp.getVariable("b"));
    }

    @org.junit.jupiter.api.Test
    void parse() {
        ExpressionParser temp = new ExpressionParser();
        assertEquals(2 + 4 * 3 - 8 * 8 * 8,temp.Parse("2+4*3-8^3"));
        assertEquals(4 * Math.sin(0.5) + 2 * Math.cos(2 * 0.5),temp.Parse("4*sin(0.5)+2*cos(2*0.5)"));
        assertEquals( 63 & 95,temp.Parse("63 & 95"));
        temp.setVariable("f", 2.0);
        assertEquals(2 * 2 * 50,temp.Parse("2*f*50"));
        assertEquals(Math.E * Math.E + 1,temp.Parse("e^2+1"));
    }

    @org.junit.jupiter.api.Test
    void parseNo() {
        ExpressionParser temp = new ExpressionParser();
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            temp.Parse("2*(5-7");
        });
        assertNotNull(thrown.getMessage());

        thrown = assertThrows(NoSuchElementException.class, () -> {
            temp.Parse("");
        });
        assertNotNull(thrown.getMessage());

        thrown = assertThrows(NumberFormatException.class, () -> {
            temp.Parse("6.78.-7");
        });
        assertNotNull(thrown.getMessage());
    }
}
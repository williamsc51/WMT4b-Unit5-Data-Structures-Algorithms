import static org.junit.Assert.*;

import org.junit.Test;

public class BalanceParenthesesTest {
    String balancedParens = "(1)";
    String tooManyOpenParens = "((1";
    String tooManyOpenParens1 = "(1)(";
    String tooManyClosedParens = "(1))";
    String startClosedParens = ")(";
    String emptyString = "";
    String balancedAngleBrackets = "<<>>";
    String balancedComboBrackets = "<({})>";
    String mismatchedBrackets = "<({)}>";

    private BalanceParentheses balanceParen = new BalanceParentheses();

    @Test
    public void testBalancedBrackets_balancedParens() {
        assertTrue(balanceParen.matchBrackets("(1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyOpenParens() {
        assertFalse(balanceParen.matchBrackets("({1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyClosedParens() {
        assertFalse(balanceParen.matchBrackets("({1})>"));
    }

    @Test
    public void testBalancedBrackets_emptyString() {
        assertTrue(balanceParen.matchBrackets(""));
    }

    @Test
    public void testBalancedBrackets_balancedComboBrackets() {
        assertTrue(balanceParen.matchBrackets("<({})>"));
    }

    @Test
    public void testBalancedBrackets_mismatchedBrackets() {
        assertTrue(balanceParen.matchBrackets("<({)}>"));
    }

}
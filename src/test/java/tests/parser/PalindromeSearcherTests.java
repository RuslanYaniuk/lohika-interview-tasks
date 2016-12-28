package tests.parser;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static parser.PalindromeSearcher.isPalindrome;

/**
 * @author Ruslan Yaniuk
 * @date December 2016
 */
public class PalindromeSearcherTests {

    @Test
    public void isPalindrome_palindromeWord_trueReturned() {
        assertTrue(isPalindrome("anna"));
        assertTrue(isPalindrome("123321"));
        assertFalse(isPalindrome("123456789"));
    }
}

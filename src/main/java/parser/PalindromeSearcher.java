package parser;

/**
 * @author Ruslan Yaniuk
 * @date December 2016
 */
public class PalindromeSearcher {

    public static boolean isPalindrome(String word) {
        char[] data = word.toCharArray();

        for (int i = 0; i < data.length; i++) {
            if (data[i] != data[data.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

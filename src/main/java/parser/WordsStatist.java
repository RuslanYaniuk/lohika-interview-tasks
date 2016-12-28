package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Yaniuk
 * @date December 2016
 */
public class WordsStatist {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> ws = new WordsStatist().getTopOccurrences(Paths.get(validateKey(args)));
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(ws.entrySet());

        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println("Top rated words:");
        System.out.println("Word   |    score  | palindrome");
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + "   |    " + e.getValue() + "   |    " + PalindromeSearcher.isPalindrome(e.getKey()));
        }
    }

    public Map<String, Integer> getTopOccurrences(Path file) throws IOException {
        String text = new String(Files.readAllBytes(file));
        String words[] = text.split("\\s+");
        Map<String, Integer> topOccurrences = new HashMap<>();

        for (String word : words) {
            Integer occurrence = topOccurrences.get(word) ;
            occurrence = occurrence != null ? ++occurrence : 1;
            topOccurrences.put(word, occurrence);
        }
        return topOccurrences;
    }

    private static String validateKey(String[] args) {
        if (args.length < 1 || args[0] == null || args[0].equals("")) {
            throw new RuntimeException("Provide the path to a text file");
        }
        return args[0];
    }
}

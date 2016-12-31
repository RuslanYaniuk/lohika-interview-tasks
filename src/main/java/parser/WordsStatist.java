package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Yaniuk
 * @date December 2016
 */
public class WordsStatist {

    public static void main(String[] args) throws IOException {
        System.out.println("Top rated words:");
        System.out.println("Word   |    score  | palindrome");
        for (Occurrence oc : getTopOccurrences(Paths.get(validateKey(args)))) {
            System.out.println(oc.getWord() + "   |    " + oc.getOccurrences() +
                    "   |    " + PalindromeSearcher.isPalindrome(oc.getWord()));
        }
    }

    public static Occurrence[] getTopOccurrences(Path file) throws IOException {
        String text = new String(Files.readAllBytes(file));
        String words[] = text.split("\\s+");
        Map<String, Occurrence> topOccurrences = new HashMap<>();
        Occurrence[] result;

        for (String word : words) {
            Occurrence oc = topOccurrences.get(word);
            if (oc == null) {
                topOccurrences.put(word, new Occurrence(word));
            } else {
                oc.incrementOccurrence();
            }
        }
        result = topOccurrences.values().toArray(new Occurrence[topOccurrences.size()]);
        Arrays.sort(result, (o1, o2) -> o2.getOccurrences() - o1.getOccurrences());
        return result;
    }

    private static String validateKey(String[] args) {
        if (args.length < 1 || args[0] == null || args[0].equals("")) {
            throw new RuntimeException("Provide the path to a text file");
        }
        return args[0];
    }

    public static class Occurrence {
        private String word;
        private int occurrences = 1;

        public Occurrence(String word) {
            this.word = word;
        }

        public void incrementOccurrence() {
            occurrences++;
        }

        public String getWord() {
            return word;
        }

        public int getOccurrences() {
            return occurrences;
        }
    }
}

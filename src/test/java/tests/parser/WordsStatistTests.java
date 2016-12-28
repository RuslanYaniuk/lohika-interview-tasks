package tests.parser;

import org.junit.Before;
import org.junit.Test;
import parser.WordsStatist;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ruslan Yaniuk
 * @date December 2016
 */
public class WordsStatistTests {

    WordsStatist wordsStatist;

    @Before
    public void setUp() {
        wordsStatist = new WordsStatist();
    }

    @Test
    public void getTopOccurrences_textFile_listOfWordsReturned() throws IOException, URISyntaxException {
        Map<String, Integer> topOccurrences =  wordsStatist
                .getTopOccurrences(Paths.get(ClassLoader.getSystemResource("test-text.txt").toURI()));

        assertThat(topOccurrences.get("in"), is(3));
    }
}

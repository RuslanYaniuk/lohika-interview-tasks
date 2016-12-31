package tests.parser;

import org.junit.Test;
import parser.WordsStatist;
import parser.WordsStatist.Occurrence;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ruslan Yaniuk
 * @date December 2016
 */
public class WordsStatistTests {

    @Test
    public void getTopOccurrences_textFile_listOfWordsReturned() throws IOException, URISyntaxException {
        Occurrence[] topOccurrences =  WordsStatist
                .getTopOccurrences(Paths.get(ClassLoader.getSystemResource("test-text.txt").toURI()));

        assertThat(topOccurrences[0].getWord(), is("anna"));
        assertThat(topOccurrences[0].getOccurrences(), is(3));

        assertThat(topOccurrences[1].getWord(), is("in"));
        assertThat(topOccurrences[1].getOccurrences(), is(3));
    }
}

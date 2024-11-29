package slidingwindows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubStringKDistinctCharactersTest {

    /**
     * Empty Array
     * K more than length of array
     *
     * Typical Case
     *
     * all same elements
     * all distinct elements
     */
    @ParameterizedTest
    @CsvSource({
            "'', 2, 0",
            "'araaci', 20,6",
            "'araaci', 2,4",
            "aabccc,1,3",
            "'araaci', 1,2",
            "'cbbebi',3,5"
    })
    void TestSolution(String inputString, int k, int expectedAnswer){
        LongestSubStringKDistinctCharacters longestSubStringKDistinctCharacters = new LongestSubStringKDistinctCharacters();

        int actualAnswer = longestSubStringKDistinctCharacters.solve(inputString, k);

        assertEquals(expectedAnswer,actualAnswer);

    }
}

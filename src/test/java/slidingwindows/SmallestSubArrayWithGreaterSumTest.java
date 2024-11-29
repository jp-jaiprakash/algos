package slidingwindows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestSubArrayWithGreaterSumTest {

    /**
     * Empty array
     * single element array and value less than target
     * smallest subarray = 1 (single element equal)
     * Typical Case: S=7, arr = 2,3,1,2,4,3
     * No valid subarray
     * All elements needed
     * all elements same
     */

    @ParameterizedTest
    @CsvSource({
            "'', 7, 0",
            "'5',5,1",
            "'5',6,0",
            "'2,3,1,2,4,3', 7 ,2",
            "'2,3,1,2,4,3', 700 ,0",
            "'2,3,1,2,4,3', 15 ,6",
            "'2,2,2,2,2,2', 4 ,2",

    })
    void TestSolution(String inputArray, int targetSum, int answer) {
        SmallestSubArrayWithGreaterSum smallestSubArrayWithGreaterSum = new SmallestSubArrayWithGreaterSum();
        int[] array = parseArray(inputArray);
        int actualAnswer = smallestSubArrayWithGreaterSum.solve(array, targetSum);

        assertEquals(actualAnswer, answer);
    }

    private int[] parseArray(String input) {
        if (input.isEmpty())
            return null;
        return java.util.Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}

package slidingwindows;

public class SmallestSubArrayWithGreaterSum {
    public int solve(int[] inputArray, int targetSum) {

        if (inputArray == null || inputArray.length == 0)
            return 0;

        if (inputArray.length == 1) {
            if (inputArray[0] == targetSum)
                return 1;
            else
                return 0;
        }

        int windowSum = 0, minLength = Integer.MAX_VALUE, windowStart = 0;

        for (int windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {
            windowSum += inputArray[windowEnd];

            while (windowSum >= targetSum) {
                int currentLength = windowEnd - windowStart + 1;
                if (minLength > currentLength)
                    minLength = currentLength;

                windowSum -= inputArray[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

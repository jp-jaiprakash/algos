package slidingwindows;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubStringKDistinctCharacters {
    public int solve(String inputString, int k) {
        if(inputString.isEmpty())
            return 0;

        if(k> inputString.length())
            return inputString.length();

        int start=0, end=k-1, subStringLength=0;
        String currentSubString ;
        Set<String> distinctElements ;

        while(start< inputString.length() && end< inputString.length()){
            //substring does not include end index
            currentSubString = inputString.substring(start,end+1);
            distinctElements = Arrays.stream(currentSubString.split("")).collect(Collectors.toSet());

            while (end< inputString.length() && distinctElements.size() <=k){

                end++;
                if(end< inputString.length())
                    currentSubString = inputString.substring(start,end+1);
                else
                    currentSubString = inputString.substring(start,end); // if end is at last element
                distinctElements = Arrays.stream(currentSubString.split("")).collect(Collectors.toSet());
            }
            int currentLength = end-start; // last allowed element is at location end-1
            if(currentLength > subStringLength)
                subStringLength=currentLength;
            start++;


        }

        return subStringLength;
    }
}

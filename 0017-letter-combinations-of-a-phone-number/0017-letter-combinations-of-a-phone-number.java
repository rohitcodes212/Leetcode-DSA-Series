import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] arr = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
        };
        
        List<String> resultList = new ArrayList<>();
        if (digits.length() == 0) {
            return resultList; // Return an empty list if input digits are empty
        }
        
        letterCombinationsHelper(digits, arr, 0, "", resultList);
        return resultList;
    }
    
    private void letterCombinationsHelper(String digits, String[][] arr, int index, String current, List<String> resultList) {
        if (index == digits.length()) {
            resultList.add(current);
            return;
        }
        
        int digit = digits.charAt(index) - '2'; // Convert char to int
        if (digit >= 0 && digit <= 7) { // Check if valid digit
            for (String letter : arr[digit]) {
                letterCombinationsHelper(digits, arr, index + 1, current + letter, resultList);
            }
        }
    }
}

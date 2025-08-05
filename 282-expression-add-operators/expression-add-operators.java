import java.util.*;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String path, String num, int target, int index, long calc, long tail) {
        // If we've reached the end of the string
        if (index == num.length()) {
            // Check if the built expression evaluates to the target
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        // Try every possible split of the next operand
        for (int i = index; i < num.length(); i++) {
            // If the number has more than 1 digit and starts with '0', skip it
            if (i != index && num.charAt(index) == '0') break;

            // The current number as substring and as a value
            String currStr = num.substring(index, i + 1);
            long currNum = Long.parseLong(currStr);

            if (index == 0) {
                // First number, don't add any operator
                backtrack(result, currStr, num, target, i + 1, currNum, currNum);
            } else {
                // Try adding '+'
                backtrack(result, path + "+" + currStr, num, target, i + 1, calc + currNum, currNum);

                // Try adding '-'
                backtrack(result, path + "-" + currStr, num, target, i + 1, calc - currNum, -currNum);

                // Try adding '*'
                // For '*', undo the last operand (tail) and multiply it with current number, then add
                backtrack(result, path + "*" + currStr, num, target, i + 1, calc - tail + tail * currNum, tail * currNum);
            }
        }
    }

    // Main for demonstration
    public static void main(String[] args) {
        Solution sol = new Solution();
        String num = "123";
        int target = 6;
        System.out.println(sol.addOperators(num, target)); // Output: [1+2+3, 1*2*3]
    }
}

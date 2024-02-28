import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Truncate the remaining K digits
        for(int i=0; i<k; ++i) {
            stack.pop();
        }
        
        // Convert Stack to String
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        // Remove any leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        // If the String is empty return "0"
        return (sb.length() == 0) ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3)); // Output: "1219"
        System.out.println(solution.removeKdigits("10200", 1)); // Output: "200"
        System.out.println(solution.removeKdigits("1901042", 4)); // Output: "2"
    }
}

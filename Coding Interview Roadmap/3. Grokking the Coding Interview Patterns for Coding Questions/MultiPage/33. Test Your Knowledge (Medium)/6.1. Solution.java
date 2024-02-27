import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        int idx = 0;
        StringBuilder res = new StringBuilder();
        int k = 0;
        while (idx < s.length()) {
            char current = s.charAt(idx);
            if (Character.isDigit(current)) {
                // If digit, calculate the number k
                while (Character.isDigit(s.charAt(idx))) {
                    k = k * 10 + s.charAt(idx) - '0';
                    idx++;
                }
            } else if (current == '[') {
                // Push the number k and reset k
                // Push the current result to the stack and reset result
                countStack.push(k);
                k = 0;
                resStack.push(res);
                res = new StringBuilder();
                idx++;
            } else if (current == ']') {
                // Pop a count from the countStack and append the current result that many times to the last result in resStack
                StringBuilder temp = res;
                res = resStack.pop();
                for (k = countStack.pop(); k > 0; k--) {
                    res.append(temp);
                }
                idx++;
            } else {
                // Append the current character to the result
                res.append(current);
                idx++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("3[a3[c]]")); // Output: acccacccaccc
        System.out.println(sol.decodeString("2[b3[d]]")); // Output: bdddbddd
        System.out.println(sol.decodeString("4[z]")); // Output: zzzz
    }
}

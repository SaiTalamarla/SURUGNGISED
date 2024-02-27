import java.util.*;

public class Solution {
    
    // Function to encode list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            // Add length of string, then '|', then the string itself followed by "##"
            sb.append(str.length()).append('|').append(str).append("##");
        }
        return sb.toString();
    }

    // Function to decode the encoded string back to the list of strings
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Find position of '|', which is after the length of the current string
            int delim = s.indexOf('|', i);
            
            // Extract the length of the current string
            int size = Integer.parseInt(s.substring(i, delim));
            
            // Extract the actual string using its length and add it to result list
            res.add(s.substring(delim + 1, delim + size + 1));
            
            // Move to the start of the next string
            i = delim + size + 3;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test the encode and decode functions with the example
        List<String> example = Arrays.asList("apple", "banana##cherry");
        System.out.println(sol.decode(sol.encode(example)));  // Should print ["apple", "banana##cherry"]
    }
}

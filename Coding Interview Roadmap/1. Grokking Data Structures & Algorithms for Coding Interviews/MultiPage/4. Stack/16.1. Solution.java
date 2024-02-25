import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        // Create a stack to store the simplified path components
        Stack<String> stack = new Stack<>();
        
        // Split the input path string using '/' as a delimiter
        for (String p : path.split("/")) {
            if (p.equals("..")) {
                // If the component is '..', pop the last component from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                // If the component is not empty and not '.', push it onto the stack
                stack.push(p);
            }
        }
        
        // Create a StringBuilder to build the simplified path
        StringBuilder result = new StringBuilder();
        
        // Reconstruct the simplified path by popping components from the stack
        for (String dir : stack) {
            // Insert '/' before each component to ensure correct path format
            result.append("/");
            result.append(dir);
        }
        
        // If the result is empty, return '/', otherwise return the simplified path
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test cases
        System.out.println(sol.simplifyPath("/a//b////c/d//././/..")); // Expected output: "/a/b/c"
        System.out.println(sol.simplifyPath("/../")); // Expected output: "/"
        System.out.println(sol.simplifyPath("/home//foo/")); // Expected output: "/home/foo"
    }
}

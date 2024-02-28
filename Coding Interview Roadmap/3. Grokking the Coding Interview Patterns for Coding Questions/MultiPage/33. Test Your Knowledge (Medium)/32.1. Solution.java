class Solution {
    public int numDecodings(String s) {
        // Return 0 for empty strings or strings starting with '0'
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // Initialize two variables to store results of sub-problems
        int prev = 1, current = 1;
        
        for (int i = 1; i < s.length(); i++) {
            int temp = 0;
            
            // If current character is not '0', it can be decoded on its own
            if (s.charAt(i) != '0') {
                temp = current;
            }

            // Check if two characters can be decoded together
            int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigits >= 10 && twoDigits <= 26) {
                temp += prev;
            }

            prev = current;
            current = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("121")); // Expected 3
        System.out.println(sol.numDecodings("27"));  // Expected 1
        System.out.println(sol.numDecodings("110")); // Expected 1
    }
}

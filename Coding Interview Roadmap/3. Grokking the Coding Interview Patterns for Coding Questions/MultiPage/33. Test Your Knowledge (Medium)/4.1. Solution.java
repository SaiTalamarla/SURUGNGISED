import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold sorted word as key and list of words as value
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            // If the sorted word is not already a key in the map, add it with a new list as its value
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            // Add the original word to the list of values for the sorted word key
            map.get(sorted).add(str);
        }
        // Return the values of the map as a list of lists
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(new String[]{"dog", "god", "hello"}));
        System.out.println(sol.groupAnagrams(new String[]{"listen", "silent", "enlist"}));
        System.out.println(sol.groupAnagrams(new String[]{"abc", "cab", "bca", "xyz", "zxy"}));
    }
}

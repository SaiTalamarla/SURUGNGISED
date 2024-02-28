public class Solution {
    
    // Function to traverse the connected cities using Depth First Search
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);  // Recursive DFS call
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;  // Counter for number of provinces
        int n = isConnected.length;
        boolean[] visited = new boolean[n];  // Array to keep track of visited cities

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);  // DFS call for every unvisited city
                provinces++;  // Increment province counter for every new DFS invocation
            }
        }
        return provinces;  // Return total provinces
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] test1 = {{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] test2 = {{1,0,0,1}, {0,1,1,0}, {0,1,1,0}, {1,0,0,1}};
        int[][] test3 = {{1,0,0}, {0,1,0}, {0,0,1}};

        System.out.println(solution.findCircleNum(test1));  // Expected output: 2
        System.out.println(solution.findCircleNum(test2));  // Expected output: 2
        System.out.println(solution.findCircleNum(test3));  // Expected output: 3
    }
}

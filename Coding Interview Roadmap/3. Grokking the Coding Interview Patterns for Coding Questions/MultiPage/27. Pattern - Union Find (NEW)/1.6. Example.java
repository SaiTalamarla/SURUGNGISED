public class Solution {
    private int[] Rank;
    private int[] Parent;
    private int N;

    // Constructor to create and initialize sets of n items
    public Solution(int n) {
        Rank = new int[n];
        Parent = new int[n];
        this.N = n;
        makeSet();
    }

    // Creates n single item sets
    public void makeSet() {
        for (int i = 0; i < N; i++) {
            // Initially, all elements are in their own set.
            Parent[i] = i;
            // All ranks are initially 1.
            Rank[i] = 1;
        }
    }

    // Finds the representative of the set that x is an element of
    public int find(int x) {
        if (Parent[x] != x) {
            // If x is not the parent of itself,
            // Then x is not the representative of his set.
            Parent[x] = find(Parent[x]);

            // so we recursively call Find on its parent
            // and move i's node directly under the representative of this set
        }
        return Parent[x];
    }

    // Unites the set that includes x and the set that includes y
    public void Union(int x, int y) {
        // Find the representatives (or the root nodes) for x and y
        int xSet = find(x);
        int ySet = find(y);

        // If they are already in the same set, return
        if (xSet == ySet)
            return;

        // Put smaller ranked item under bigger ranked item if ranks are different
        if (Rank[xSet] < Rank[ySet]) {
            Parent[xSet] = ySet;
        } else if (Rank[xSet] > Rank[ySet]) {
            Parent[ySet] = xSet;
        } else {
            // If ranks are the same, then move y under x (doesn't matter which one goes where)
            // and increment the result tree's rank by 1
            Parent[ySet] = xSet;
            Rank[xSet]++;
        }
    }
    
    public static void main(String[] args) {
        // Create a disjoint set data structure with 5 elements.
        Solution obj = new Solution(5);
        // Merge sets that contain 0 and 2.
        obj.Union(0, 2);
        // Merge sets that contain 4 and 2.
        obj.Union(4, 2);
        // Merge sets that contain 3 and 1.
        obj.Union(3, 1);
        // Check if 4 and 0 are in the same set.
        if (obj.find(4) == obj.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
        // Check if 1 and 0 are in the same set.
        if (obj.find(1) == obj.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}




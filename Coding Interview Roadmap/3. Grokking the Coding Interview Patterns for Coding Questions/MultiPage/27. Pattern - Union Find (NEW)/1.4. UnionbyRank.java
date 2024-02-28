public void unionByRank(int i, int j) {
    // Find the representatives of the sets that i and j are part of.
    int irep = find(i);
    int jrep = find(j);

    // If i and j are already in the same set, nothing to do.
    if (irep == jrep) {
        return;
    }

    // Attach the tree with the smaller rank to the tree with the larger rank.
    if (rank[irep] < rank[jrep]) {
        parent[irep] = jrep;
    } else if (rank[irep] > rank[jrep]) {
        parent[jrep] = irep;
    } else {
        // If ranks are the same, make one the parent of the other and increase its rank.
        parent[irep] = jrep;
        rank[jrep]++;
    }
}

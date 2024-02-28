public void union(int i, int j) {
    // Find the representatives of the two sets.
    int irep = find(i);
    int jrep = find(j);
    
    // If they are already in the same set, return.
    if (irep == jrep) {
        return;
    }
    
    // Make the representative of the first set point to the representative of the second set.
    parent[irep] = jrep;
}

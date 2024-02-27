public void unionBySize(int i, int j) {
    // Find the root of each set
    int irep = find(i);
    int jrep = find(j);
    
    // If both elements are in the same set, exit the method
    if (irep == jrep) {
        return;
    }
    
    // Attach the smaller set to the larger one
    if (size[irep] < size[jrep]) {
        parent[irep] = jrep; // Set jrep as the new parent of irep
        size[jrep] += size[irep]; // Increase the size of the set that jrep is a representative of
    } else {
        parent[jrep] = irep; // Set irep as the new parent of jrep
        size[irep] += size[jrep]; // Increase the size of the set that irep is a representative of
    }
}

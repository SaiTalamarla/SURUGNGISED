// Java implementation of the find function
public int find(int i) {
  // If the element is the parent of itself
  if (parent[i] == i) {
    // Then it is the representative of its set
    return i;
  } else {
    // Otherwise, recursively find the representative of the set to which 'i' belongs
    int result = find(parent[i]);
    // Path Compression: Directly connect 'i' to the representative of its set
    parent[i] = result;
    // Return the representative
    return result;
  }
}

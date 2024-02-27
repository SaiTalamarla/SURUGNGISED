public int find(int i) {
  // If the element is its own parent, it's the representative of its set.
  if (parent[i] == i) {
      return i;
  }
  // Otherwise, recursively find the representative of the set.
  else {
    return find(parent[i]);
  }
}

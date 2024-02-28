public boolean delete(int key) {
    int index = hash(key);

    if (htArray[index].key == key) {
        htArray[index].key = -1; // Mark the slot as empty
        length--;
        return true;
    }
    return false; // The slot is already empty or there is a different item at the slot
}

public boolean insert(Record item) {
    if (length == maxLength) {
        System.err.println("Hash table is full. Cannot insert the key-value pair.");
        return false;
    }

    int index = hash(item.Key);
    htArray[index] = item;
    length++;
    return true;
}

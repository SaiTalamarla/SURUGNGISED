public boolean search(int key, Record returnedItem) {
    int index = hash(key);

    if (htArray[index].key == -1) {
        return false; // Record not found
    }
    returnedItem.key = htArray[index].key;
    returnedItem.title = htArray[index].title;
    returnedItem.placementInfo = htArray[index].placementInfo;
    return true; // Return true to indicate the record was found
}
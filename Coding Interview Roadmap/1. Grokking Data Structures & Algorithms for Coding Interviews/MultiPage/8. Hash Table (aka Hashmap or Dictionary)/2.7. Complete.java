import java.util.Arrays;

class Record {
    public int key;
    public String title;
    public String placementInfo;

    public Record() {
        key = -1;
    }

    public Record(int key, String title, String placementInfo) {
        this.key = key;
        this.title = title;
        this.placementInfo = placementInfo;
    }
}

class HashTable {
    private Record[] htArray;
    private int maxLength;
    private int length;

    public HashTable(int size) {
        maxLength = size;
        length = 0;
        htArray = new Record[size];
        Arrays.fill(htArray, new Record());
    }

    private int hash(int key) {
        return key % maxLength;
    }

    public boolean Insert(Record item) {
        if (length == maxLength) {
            System.err.println("Hash table is full. Cannot insert the key-value pair.");
            return false;
        }

        int index = hash(item.key);
        htArray[index] = item;
        length++;
        return true;
    }

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

    public boolean delete(int key) {
        int index = hash(key);

        if (htArray[index].key == key) {
            htArray[index].key = -1; // Mark the slot as empty
            length--;
            return true;
        }
        return false; // The slot is already empty or there is a different item at the slot
    }
}

class Solution {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        // Insert book information
        hashTable.Insert(new Record(1001, "Introduction to Programming", "A2 Shelf"));
        hashTable.Insert(new Record(1002, "Data Structures and Algorithms", "B1 Shelf"));
        hashTable.Insert(new Record(1003, "Database Management Systems", "C3 Shelf"));

        // Retrieve book information
        Record book = new Record();
        if (hashTable.search(1001, book)) {
            System.out.println("Book Information for Key " + book.key + ":");
            System.out.println("Title: " + book.title);
            System.out.println("Placement Info: " + book.placementInfo);
        } else {
            System.out.println("No book information found for Key 1001");
        }

        // Delete a book information
        hashTable.delete(1001);

        // Retrieve the book status after deletion
        if (hashTable.search(1001, book)) {
            System.out.println("Book Information for Key " + book.key + ":");
            System.out.println("Title: " + book.title);
            System.out.println("Placement Info: " + book.placementInfo);
        } else {
            System.out.println("No book information found for Key 1001");
        }
    }
}
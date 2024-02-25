import java.util.ArrayList;
import java.util.List;

class Record {
    int Key;
    String Title;
    String PlacementInfo;

    public Record(int key, String title, String placement_info) {
        Key = key;
        Title = title;
        PlacementInfo = placement_info;
    }
}

class HashTable {
    private List<List<Record>> buckets; // List of lists to store the chains
    private int max_length; // To store the maximum number of elements a Hash table can store

    public HashTable(int size) {
        max_length = size;
        buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private int H(int key) {
        return key % max_length;
    }

    public boolean Insert(Record item) {
        int index = H(item.Key);

        // Traverse the chain at the index
        for (Record record : buckets.get(index)) {
            if (record.Key == item.Key) {
                return false; // Key already exists in the chain, cannot insert
            }
        }

        buckets.get(index).add(item);
        return true;
    }

    public boolean Search(int key, Record returnedItem) {
        int index = H(key);

        // Traverse the chain at the index
        for (Record record : buckets.get(index)) {
            if (record.Key == key) {
                returnedItem.Key = record.Key;
                returnedItem.Title = record.Title;
                returnedItem.PlacementInfo = record.PlacementInfo;
                return true; // Return true to indicate the record was found
            }
        }

        return false; // Record not found
    }

    public boolean Delete(int key) {
        int index = H(key);

        // Traverse the chain at the index
        List<Record> chain = buckets.get(index);
        for (int i = 0; i < chain.size(); i++) {
            Record record = chain.get(i);
            if (record.Key == key) {
                chain.remove(i);
                return true;
            }
        }

        return false; // The key is not found in the chain
    }

    public void ShowTable() {
        System.out.println("Index\tValue (Key, Title, PlacementInfo)");
        for (int i = 0; i < max_length; i++) {
            System.out.print(i + "\t");
            List<Record> chain = buckets.get(i);
            if (chain.isEmpty()) {
                System.out.println("[EMPTY BUCKET]");
            } else {
                for (int j = 0; j < chain.size(); j++) {
                    Record record = chain.get(j);
                    if (j > 0) {
                        System.out.print("--> ");
                    }
                    System.out.print("(" + record.Key + ", " + record.Title + ", " + record.PlacementInfo + ")");
                }
                System.out.println();
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        int tableSize = 11;
        HashTable hashTable = new HashTable(tableSize);

        // Insert initial book information
        hashTable.Insert(new Record(1701, "Internet of Things", "G1 Shelf"));
        hashTable.Insert(new Record(1712, "Statistical Analysis", "G1 Shelf"));
        hashTable.Insert(new Record(1718, "Grid Computing", "H2 Shelf"));
        hashTable.Insert(new Record(1735, "UML Modeling", "G1 Shelf"));
        hashTable.Insert(new Record(1752, "Professional Practices", "G2 Shelf"));

        // Display the hash table after initial insertions
        System.out.println("\nHash Table after initial insertions:");
        hashTable.ShowTable();

        // Insert the following record
        hashTable.Insert(new Record(1725, "Deep Learning with Python", "C3 Shelf"));

        // Display the hash table after the last insertion
        System.out.println("\nHash Table inserting Book Key 1725:");
        hashTable.ShowTable();

        // Delete two records
        hashTable.Delete(1701);
        hashTable.Delete(1718);

        // Display the hash table after deletions
        System.out.println("\nHash Table after deleting 1701 and 1718:");
        hashTable.ShowTable();
    }
}
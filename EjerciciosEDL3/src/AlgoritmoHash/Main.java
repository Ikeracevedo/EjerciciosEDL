package AlgoritmoHash;
import java.util.LinkedList;

class HashEntry<K, V> {
    K key;
    V value;

    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable<K, V> {
    private int SIZE = 10;
    private LinkedList<HashEntry<K, V>>[] buckets;

    public HashTable() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void insert(K key, V value) {
        int index = getIndex(key);
        for (HashEntry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new HashEntry<>(key, value));
    }

    public V search(K key) {
        int index = getIndex(key);
        for (HashEntry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (HashEntry<K, V> entry : buckets[i]) {
                System.out.print("[" + entry.key + "," + entry.value + "] ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String> map = new HashTable<>();
        map.insert(5, "A");
        map.insert(6, "B");
        map.insert(3, "C");
        map.insert(15, "D");
        map.insert(25, "E");
        map.insert(56, "G");

        map.display();

        System.out.println("Buscar 15: " + map.search(15));
        System.out.println("Buscar 40: " + map.search(40));

        map.remove(15);
        map.display();
    }
}
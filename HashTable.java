
import java.util.*;
@SuppressWarnings("unchecked")

public class HashTable<K, V> {
    private final int tableSize;
    private final LinkedList<Entry<K, V>>[] buckets;
    private static int size = 0;

    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        this.buckets = new LinkedList[this.tableSize];
        for (int i = 0; i < this.tableSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
        size = 0;
    }
    
    public int Size(){return size;}
    public boolean isEmpty(){
        return Size() == 0;
    }



    private int Hashcode(K key){
        return Objects.hashCode(key);
    }


    private int getBucketIndex(K key){
        int hashcode = Hashcode(key);
        int index = hashcode % tableSize;
        index = index < 0 ? index*(-1): index;
        return index;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        List<Entry<K, V>> bucket = buckets[bucketIndex];
        Entry<K, V> head = bucket.isEmpty() ? null : bucket.getFirst();

        // Перебор всех элементов в корзине
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                break;
            }
            head = head.next;
        }
        

        // Элемент не найден, добавляем новый
        if (head == null) {
            bucket.addLast(new Entry<>(key, value));
            size++;
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        List<Entry<K, V>> bucket = buckets[bucketIndex];
        Entry<K, V> head = bucket.isEmpty() ? null : bucket.getFirst();

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        List<Entry<K, V>> bucket = buckets[bucketIndex];
        Entry<K, V> head = bucket.isEmpty() ? null : bucket.getFirst();

        while (head != null) {
            if (head.key.equals(key)) {
                bucket.remove(head);
                size--;
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable<Integer, String> myHashTable = new HashTable<>(10);
        myHashTable.put(1, "One");
        myHashTable.put(2, "Two");
        myHashTable.put(3, "Three");
        myHashTable.put(4, "Four");
        myHashTable.put(5, "Five");
        myHashTable.remove(1);

        System.out.println("Size of the hash table: " + myHashTable.Size());
        System.out.println("Contains 1? " + myHashTable.get(1));
        System.out.println("Contains 7? " + myHashTable.get(7));
    }

}
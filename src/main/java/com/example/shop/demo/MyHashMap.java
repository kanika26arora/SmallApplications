package com.example.shop.demo;

public class MyHashMap<K, V> {

    int capacity;
    float loadFactor;
    int MAX_CAPACITY = 1 << 30;
    int DEFAULT_CAPACITY = 1 << 4;

    float LOAD_FACTOR = 0.75f;

    int fillFactor = 0;

    Entry<K, V>[] hashTable;

    MyHashMap(){
        this.capacity = DEFAULT_CAPACITY;
        this.hashTable = new Entry[capacity];
        this.loadFactor = LOAD_FACTOR;
    }

    MyHashMap(int capacity){
        this.hashTable = new Entry[capacity];
        if(capacity > MAX_CAPACITY){
            this.capacity = MAX_CAPACITY;
        } else{
            this.capacity = generateCapacity(capacity);
        }
        this.loadFactor = LOAD_FACTOR;
    }

    MyHashMap(int capacity, float loadFactor){
        this.hashTable = new Entry[capacity];
        if(capacity > MAX_CAPACITY){
            this.capacity = MAX_CAPACITY;
        } else{
            this.capacity = generateCapacity(capacity);
        }
        this.loadFactor = loadFactor;
    }

    private int generateCapacity(int cap){

        int n = cap-1;

        n = n | ( n >>> 1);
        n = n | ( n >>> 2);
        n = n | ( n >>> 4);
        n = n | ( n >>> 8);
        n = n | ( n >>> 16);

        n = n+1;

        if(n < 0){
            return DEFAULT_CAPACITY;
        } else if (n > MAX_CAPACITY) {
            return MAX_CAPACITY;
        } else {
            System.out.println("Capacity is " + n);
            return n;
        }
    }

    private int generateHashCode(int key){
        return (key % capacity);
    }

    public void put(K key, V value){

        int hashCode = generateHashCode((Integer) key);

        if(hashTable[hashCode] == null){

            Entry<K, V> entry = new Entry<>(key, value);
            hashTable[hashCode] = entry;
            fillFactor++;
        } else {

            if(hashTable[hashCode].key == key){
                hashTable[hashCode].value = value;
            } else{
                Entry node = hashTable[hashCode];
                while (node.next != null){
                    node = node.next;
                }
                node.next = new Entry<>(key, value);
                fillFactor++;
            }
        }

//        if((float) (fillFactor * 100) /capacity > (loadFactor*100)){
//            this.capacity = generateCapacity(capacity+1);
//        }

    }

    public V get(K key){

        int hashCode = generateHashCode((Integer) key);

        Entry node = hashTable[hashCode];

        while (!node.key.equals(key)){
            node = node.next;
        }

        return (V) node.value;

    }
}

class Entry<K, T> {

    K key;
    T value;
    Entry next;

    Entry(K key, T value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}


class Main{

    public static void main(String... s){

        MyHashMap<Integer, String> map = new MyHashMap<>(4);

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");
        map.put(9, "I");
        map.put(10, "J");

        System.out.println(map.get(3));

    }
}

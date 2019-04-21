package Homework12;

import java.util.Arrays;

public class MyHashMap<K, V> {
        private static final int CAPACITY = 12;
        private int size = 0;
        private Node<K, V>[] table;

        public MyHashMap(int capacity) {

            table = (Node<K, V>[]) new Node[capacity];
        }

        public MyHashMap()
        {
            this(CAPACITY);
        }

        private static class Node<K, V> {
            private final int hash;
            private final K key;
            private V value;
            Node<K, V> next;

            Node(int hash, K key, V value, Node<K,V> next) {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }

            public final V setValue(V value) {
                this.value = value;
                return value;
            }

            @Override
            public String toString() {
                return key + " has value: " + value;
            }
        }

        public static int increaseCapacity(int increaseValue){
            return CAPACITY + increaseValue;
        }

        private final int hash(K key) {
            return key.hashCode();
        }

        public void put(K key, V value) {
            if (indexOf(key) != -1) {
                Node<K, V> current = getNode(key);
                current.setValue(value);
            } else {
                Node<K, V> current = new Node<>(hash(key), key, value, null);
                int index = hash(key) % table.length;
                if (table[index] != null) {
                    table[index].next = current;
                } else {
                    table[index] = current;
                }
            }
            size++;
        }

        public V get(K key) {
            if (indexOf(key) != -1) {
                Node<K, V> node = getNode(key);
                return node.value;
            }
            return null;
        }

        private Node<K, V> getNode(K key) {
            for (int i = 0; i < table.length; i++) {
                if ((table[i] != null) && (table[i].hash == hash(key))) {
                    return table[i];
                }
            }
            return null;
        }

        public V remove(K key) {
            if (indexOf(key) != -1) {
                Node<K, V> removedNode = getNode(key);
                table[indexOf(key)] = null;
                size--;
                return removedNode.value;
            }
            return null;
        }

        private int indexOf(K key) {
            for (int i = 0; i < table.length; i++) {
                if ((table[i] != null) && (hash(key) == (table[i].hash))) {
                    return i;
                }
            }
            return -1;
        }

        public void clear() {
            table = (Node<K, V>[]) new Node[CAPACITY];
            size = 0;
        }

        public int size() {
            return size;
        }

    @Override
        public String toString() {
            StringBuilder result = new StringBuilder("[");
            int indexOfFirst = 0;
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    result.append(table[i]);
                    indexOfFirst = i + 1;
                    break;
                }
            }
            for (int i = indexOfFirst; i < table.length; i++) {
                if (table[i] != null) {
                    result.append(", ").append(table[i]);
                }
            }
            result.append("]");
            return result.toString();
        }
    }
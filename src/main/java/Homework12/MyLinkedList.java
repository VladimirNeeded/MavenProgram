package Homework12;

public class MyLinkedList<T> implements List<T> {
    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    @Override
    public void add(T value) {
        if (size == 0) {
            firstNode = new Node(null, null, value);
            lastNode = firstNode;
        } else if (size == 1) {
            lastNode = new Node(firstNode, null, value);
            firstNode.next = lastNode;
        } else {
            Node<T> currentNode = new Node<>(lastNode, null, value);
            lastNode.next = currentNode;
            lastNode = currentNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index == 0) {
            Node currentNode = new Node(null, firstNode, value);
            firstNode.prev = currentNode;
            firstNode = currentNode;
        } else if (index == 1) {
            Node currentNode = new Node(firstNode, firstNode.next, value);
            firstNode.next = currentNode;
            currentNode.prev = currentNode;
        } else if (index == size) {
            add(value);
        } else {
            int i = 0;
            Node indexNode = firstNode;
            while (i != index) {
                indexNode = indexNode.next;
                i++;
            }
            Node currentNode = new Node(indexNode.prev, indexNode, value);
            currentNode.prev.next = currentNode;
            currentNode.next.prev = currentNode;
        }
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        MyLinkedList<T> linkedlist = (MyLinkedList<T>) list;
        this.lastNode.next = linkedlist.firstNode;
        linkedlist.firstNode.prev = this.lastNode;
        lastNode = linkedlist.lastNode;
        this.size += linkedlist.size;
    }

    @Override
    public T get(int index) {
        Node<T> nodeOfIndex = firstNode;
        for (int i = 0; i < index; i++){
            nodeOfIndex = firstNode.next;
        }
        return nodeOfIndex.value;
    }

    @Override
    public void set(T value, int index) {
        int checkIndex = 0;
        Node<T> nodeOfIndex = firstNode;
        while (checkIndex != index){
            nodeOfIndex = firstNode.next;
        }
        nodeOfIndex.value = value;
    }

    @Override
    public T remove(int index) {

        int checkIndex = 0;
        Node<T> nodeOfIndex = firstNode;
        if (index == 0) {
            firstNode = firstNode.next;
        }
        while (checkIndex != index){
            nodeOfIndex = firstNode.next;
        }
        if (index == 0) {
            firstNode = nodeOfIndex.next;
            firstNode.prev = null;
            size--;
            return nodeOfIndex.value;
        } else if (index == (size - 1)) {
            lastNode = nodeOfIndex.prev;
            lastNode.next = null;
            size--;
            return nodeOfIndex.value;
        }
        nodeOfIndex.prev.next = nodeOfIndex.next;
        nodeOfIndex.next.prev = nodeOfIndex.prev;
        size--;
        return nodeOfIndex.value;
    }

    @Override
    public T remove(T t) {
        Node<T> removedNode = firstNode;
        if (firstNode.value == t){
            firstNode = firstNode.next;
        }
        else {
            while (removedNode.value != t){
                removedNode = firstNode.next;
            }
        }
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
        size--;
        return removedNode.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<T> {
        private Node prev;
        private Node next;
        private T value;

        public Node(Node prev, Node next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
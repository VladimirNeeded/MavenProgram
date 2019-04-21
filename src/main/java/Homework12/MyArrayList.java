package Homework12;

import java.util.Arrays;

public class MyArrayList <T> implements List<T> {
    private int size = 0;
    private int capacity = 0;
    private T[] array;

    public MyArrayList() {

        array = (T[]) new Object[capacity];
    }

    public MyArrayList(int size) {

        array = (T[]) new Object[size];
    }

    @Override
    public void add(T value) {
        increaseCapacity();
        array[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        increaseCapacity();
        for (int i = index; i < array.length - 1; i++) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        array = Arrays.copyOf(array, array.length + list.size());
        for (int i = array.length - list.size(), j = 0; i < array.length; i++, j++){
            array[i] = list.get(j);
            size++;
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
            array[index] = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedValue = array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array = Arrays.copyOf(array, array.length - 1);
        return removedValue;
    }

    @Override
    public T remove(T o) {
        int index = Arrays.asList(array).indexOf(o);
        for (int i = index; i < array.length - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        array = Arrays.copyOf(array, array.length - 1);
        return o;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    private void increaseCapacity(){
        array = Arrays.copyOf(array,array.length + 1);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException("Index is not corrected");
        }
    }
}
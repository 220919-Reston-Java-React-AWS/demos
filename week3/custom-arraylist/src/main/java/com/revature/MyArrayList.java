package com.revature;

public class MyArrayList<E> { // E is a generic parameter -> concept of generics

    private E[] array;
    private int numOfElements = 0; // 0

    public MyArrayList() {
        this.array = (E[]) new Object[4]; // create an array of size 16 to start with
    }

    public E get(int index) {
        return array[index];
    }

    public int size() {
        return numOfElements;
    }

    public void add(E element) {
        // Check if numOfElements < array.length
        if (numOfElements < array.length) {
            array[numOfElements] = element;
            numOfElements++;
        } else { // we ran out of space in the old array, we need to create a new one
            int newSize = (int) (array.length * 1.5);
            E[] newArray = (E[]) new Object[newSize];

            // Copy elements from old array to new array
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            // Set array to point to the new array
            array = newArray;

            // add new element
            array[numOfElements] = element;
            numOfElements++;
        }
    }

    // Same logic in terms of checking if array is full or not
    // where it is different is that we need to shift elements to the right before adding the new element
//    public void add(int index, E element) {
//
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for (int i = 0; i < numOfElements - 1; i++) {
            sb.append(array[i] + ", ");
        }

        sb.append(array[numOfElements - 1] + " ]");

        return sb.toString();
        // [ x, y, z, ... ]
    }
}

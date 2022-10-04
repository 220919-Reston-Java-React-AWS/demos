package com.revature;

public class MyLinkedList<E> {

    // inner class
    class Node { // represents an element
        Node next; // pointer to the next Node
        Node prev; // pointer to the previous Node
        E value; // value for the element
    }

    private int numOfElements;
    private Node head;
    private Node tail;

    public void add(E value) {
        if (head == null && tail == null) { // no elements exist
            Node newElement = new Node();
            newElement.value = value;

            this.head = newElement;
            this.tail = newElement;
        } else {
            Node newElement = new Node();
            newElement.value = value;

            // this method should add nodes to the end of the linkedlist, so we will have the original tail point to the new tail
            newElement.prev = tail;
            tail.next = newElement;
            tail = newElement;

        }

        numOfElements++;
    }

    public E get(int index) {
        // Logic:

        // Optimization: if somebody is looking for an element to the right of the midpoint of the linkedlist, we should start at tail and iterate backwards to save time
        // if somebody is looking for an element to the left of the midpoint of the linkedlist, we should start at head and iterate forwards to save time

        // linkedlist with 100 elements
        // .get(99): without the optimization, we start at head and have to iterate all the way to the end of the linkedlist
        // .get(99): with the optimization, we start at element 100 and only need to go to the left by 1

        // if index > (numOfElements) / 2 <- start at the tail and work backwards
        // if index <= (numOfElements) / 2 <- start at the head and work forwards

        Node currentNode = head;

        if (index <= (numOfElements) / 2) {
            currentNode = head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;

            for (int i = 0; i < (numOfElements - 1 - index); i++) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.value;
    }
    
}

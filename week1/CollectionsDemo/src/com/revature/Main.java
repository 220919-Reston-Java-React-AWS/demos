package com.revature;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // These are our various collections
        listDemo();
        setDemo();
        queueDemo();
        mapDemo();
    }

    public static void mapDemo() {
        Map<Character, Integer> characterCount = new HashMap<>();

        // Coding challenge: count the frequency of characters in a String
        // "a": 32
        // "b": 45
        String s = "Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner. Among the exceptions are priority queues, which order elements according to a supplied comparator, or the elements' natural ordering, and LIFO queues (or stacks) which order the elements LIFO (last-in-first-out). Whatever the ordering used, the head of the queue is that element which would be removed by a call to remove() or poll(). In a FIFO queue, all new elements are inserted at the tail of the queue. Other kinds of queues may use different placement rules. Every Queue implementation must specify its ordering properties.";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if key-value pair already exists
            if (characterCount.containsKey(c)) {
                int newCount = characterCount.get(c) + 1;
                characterCount.put(c, newCount);
            } else {
                characterCount.put(c, 1);
            }
        }

        // See how many a's there are in the string
        System.out.println(characterCount.get('a')); // 27
        System.out.println(characterCount.get('b')); // 3
        System.out.println(characterCount.get('z')); // null

        // Loop through Map

        // Method #1
        Set<Character> keys = characterCount.keySet();
        for (char c : keys) {
            System.out.println(c + " : " + characterCount.get(c));
        }

        // Method #2
        Set<Map.Entry<Character, Integer>> setOfKeyValuePairs = characterCount.entrySet();
        for (Map.Entry<Character, Integer> keyValueEntry : setOfKeyValuePairs) {
            System.out.println(keyValueEntry.getKey() + " : " + keyValueEntry.getValue());
        }

    }

    public static void queueDemo() {
        Queue<String> myLinkedListQueue = new LinkedList<>();

        myLinkedListQueue.offer("b"); // 1st
        myLinkedListQueue.offer("a"); // 2nd

        System.out.println(myLinkedListQueue.poll()); // b
        System.out.println(myLinkedListQueue.poll()); // a

        Queue<String> myPriorityQueue = new PriorityQueue<>();

        myPriorityQueue.offer("b"); // 1st
        myPriorityQueue.offer("a"); // 2nd

        System.out.println(myPriorityQueue.poll()); // a skipped in line because a is smaller than b (higher priority)
        System.out.println(myPriorityQueue.poll()); // b

        myPriorityQueue.offer("a"); // 1st
        myPriorityQueue.offer("c"); // 2nd
        myPriorityQueue.offer("b"); // 3rd

        System.out.println(myPriorityQueue.poll()); // a
        System.out.println(myPriorityQueue.poll()); // b skipped c
        System.out.println(myPriorityQueue.poll()); // c
    }

    public static void setDemo() {
        Set<String> myHashSet = new HashSet<>();

        myHashSet.add("Dog");
        myHashSet.add("Cat");
        myHashSet.add("Elephant");
        myHashSet.add("Horse");
        myHashSet.add("Zebra");

        System.out.println(myHashSet.contains("Gorilla")); // O(1) false
        System.out.println(myHashSet.contains("Horse")); // O(1) true
        // Advantage of a Set over a List is that you can instantaneously lookup whether something exists
        // in the Set or not
        // It's especially useful for tracking things you have already encountered
        myHashSet.add("Dog"); // Will not add another Dog string because it already exists
        myHashSet.add("Dog"); // Will not add another Dog string because it already exists
        myHashSet.add("Dog"); // Will not add another Dog string because it already exists
        myHashSet.add("Dog"); // Will not add another Dog string because it already exists

        // NOTE: there's no particular order in which the elements get printed (HashSet)
        for (String s : myHashSet) { // for-each loop
            System.out.println(s);
        }

        Set<String> myTreeSet = new TreeSet<>();

        myTreeSet.add("Dog");
        myTreeSet.add("Cat");
        myTreeSet.add("Elephant");
        myTreeSet.add("Horse");
        myTreeSet.add("Zebra");

        // NOTE: elements are printed in alphabetical order (TreeSet)
        for (String s : myTreeSet) {
            System.out.println(s);
        }

    }

    public static void listDemo() {
        // A List is used to store data that is indexed and in a certain sequence
        // The reason you would use a List is so that you can continuously add more data
        //  -> Lists DO NOT have a fixed size (they can expand)
        //  -> Lists have this advantage over arrays (because arrays have a fixed size)
        int[] myInts = new int[5]; // [0, 0, 0, 0, 0]
        myInts[0] = 10;
        myInts[1] = 20;
        myInts[2] = 30;
        myInts[3] = 40;
        myInts[4] = 50;

        // myInts = [10, 20, 30, 40, 50]

        // NOT ALLOWED!
        // myInts[5] = 100; // ArrayIndexOutOfBoundsException

        // List is the interface, ArrayList is a class that implements the List interface
        List<Integer> myListOfInts = new ArrayList<>();

        myListOfInts.add(-10);
        myListOfInts.add(20);
        myListOfInts.add(101);

        System.out.println(calculateSum(myListOfInts));

        List<Integer> myListOfInts2 = new LinkedList<>();

        myListOfInts2.add(1);
        myListOfInts2.add(15);
        myListOfInts2.add(3);

        System.out.println(calculateSum(myListOfInts2));

        // .add(E element): add an element to the end of the list
        // .add(int index, E element): add an element at a particular position, and shift all existing elements to the right
        // .set(int index, E element): REPLACES an element at a particular position
        // .get(int index): retrieve the element from a particular index (remember indices start at 0)
        // .remove(int index): remove an element at a particular index
        // .remove(E element): remove an element with a particular value (remove the first occurrence if there's multiple)
        // .size(): return the number of elements in the list
        // .clear(): delete all elements from list
        // .contains(E element): return true if list contains a particular element, false if it doesn't

        System.out.println(myListOfInts2.get(1)); // 15
        System.out.println(myListOfInts.get(1)); // 20

        // traditional for loops
        for (int i = 0; i < myListOfInts.size(); i++) { // i is a block scoped variable
            System.out.println(myListOfInts.get(i));
        }

        for (int i = myListOfInts.size() - 1; i >= 0; i--) { // i is a block scoped variable
            System.out.println(myListOfInts.get(i));
        }

        // for - each loop
        // What the for each loop adds in terms of convenience, it subtracts in terms of flexibility
        for (int i : myListOfInts) {
            System.out.println(i);
        }

        // Iterator
        Iterator<Integer> myIter = myListOfInts.iterator();
        while (myIter.hasNext()) {
            System.out.println(myIter.next());
        }

        // Sorting
        System.out.println(myListOfInts2);
        // O(n log n)
        Collections.sort(myListOfInts2); // sort the list from least to greatest
        System.out.println(myListOfInts2);
    }

    public static int calculateSum(List<Integer> myList) {
        int answer = 0;

        for (int index = 0; index < myList.size(); index++) {
            answer = answer + myList.get(index);
        }

        return answer;
    }

}

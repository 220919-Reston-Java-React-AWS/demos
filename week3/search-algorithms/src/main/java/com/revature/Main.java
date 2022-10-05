package com.revature;

public class Main {

    public static void main(String[] args) {
        int[] myIntArray1 = { 54, 32, -1, 100, 12, 53 }; // unsorted

        System.out.println(linearSearch(myIntArray1, 333)); // -1
        System.out.println(linearSearch(myIntArray1, 100)); // 3

        int[] myIntArray2 = { -10, 2, 10, 15, 21, 35, 100 }; // sorted (least to greatest)

        System.out.println(binarySearch(myIntArray2, -10)); // 0
        System.out.println(binarySearch(myIntArray2, 100)); // 6
        System.out.println(binarySearch(myIntArray2, 21)); // 4
        System.out.println(binarySearch(myIntArray2, 13)); // -1
        // Strategy for testing an algorithm: make sure to check the "edges", the middle, and something that doesn't exist
    }

    // -1 means we didn't find anything
    // anything else is the index in which the element was found
    // O(n): the amount of time it takes scales linearly based on the size of the array
    public static int linearSearch(int[] arr, int element) {
        // This for loop could have  n number of iterations
        // where n = length of the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int element) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] < element) {
                left = mid + 1;
            } else { // arr[mid] > element
                right = mid - 1;
            }
        }

        return -1;
    }

}

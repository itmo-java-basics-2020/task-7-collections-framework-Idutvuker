package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private PriorityQueue<Integer> largestQueue = new PriorityQueue<>();
    private final int k;

    private void addToLargestQueue(int value) {
        if (largestQueue.size() < k) {
            largestQueue.add(value);
        }
        else if (largestQueue.peek() < value) {
            largestQueue.poll();
            largestQueue.add(value);
        }

    }

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        for (int value : numbers)
            addToLargestQueue(value);
    }

    public int add(int val) {
        addToLargestQueue(val);
        return largestQueue.peek();
    }
}
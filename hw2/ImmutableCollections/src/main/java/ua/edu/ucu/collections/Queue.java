package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queue;

    public Queue() {
        queue = new ImmutableLinkedList();
    }

    public void enqueue(Object obj) {
        queue = queue.addLast(obj);
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object removedElement = queue.getFirst();
        queue = queue.removeFirst();
        return removedElement;
    }
    
}

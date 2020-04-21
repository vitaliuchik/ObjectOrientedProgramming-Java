package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testPushPeek() {
        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(0, queue.peek());
    }

    @Test
    public void testPop() {
        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(0, queue.dequeue());
        assertEquals(1, queue.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmpty() {
        Queue queue = new Queue();
        queue.dequeue();
    }
    
}

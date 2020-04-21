package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPushPeek() {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.peek());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.pop());
        assertEquals(3, stack.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmpty() {
        Stack stack = new Stack();
        stack.pop();
    }
}

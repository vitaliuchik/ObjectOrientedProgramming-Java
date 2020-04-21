package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testEmptyConstructor() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList();
        assertEquals(0, linkedList.size(), 0.0);
    }

    @Test
    public void testConstructor() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String result = "12, 3.0, hello";
        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testAddObject() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(0);
        String result = "12, 3.0, hello, 0";

        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testInsertObject() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(2, 0);
        String result = "12, 3.0, 0, hello";

        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testInsertFirstObject() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(0, 0);
        String result = "0, 12, 3.0, hello";

        assertEquals(result, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertObjectException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.add(7, 0);
    }

    @Test
    public void testAddAll() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        Object[] addition = {0, "end"};
        linkedList = (ImmutableLinkedList) linkedList.addAll(addition);
        String result = "12, 3.0, hello, 0, end";

        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testInsertAll() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        Object[] addition = {0, "end"};
        linkedList = (ImmutableLinkedList) linkedList.addAll(2, addition);
        String result = "12, 3.0, 0, end, hello";

        assertEquals(result, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAllException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        Object[] addition = {0, "end"};
        linkedList = (ImmutableLinkedList) linkedList.addAll(-2, addition);
    }


    @Test
    public void testRemove() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.remove(1);
        String result = "12, hello";

        assertEquals(result, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.remove(4);
    }

    @Test
    public void testGet() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String result = "hello";

        assertEquals(result, linkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.get(100);
    }

    @Test
    public void testSet() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.set(2, "new");
        String result = "12, 3.0, new";

        assertEquals(result, linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.set(-1, 0);
    }

    @Test
    public void testIndexOf() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertEquals(2, linkedList.indexOf("hello"));
    }

    @Test
    public void testIndexOfNotFound() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertEquals(-1, linkedList.indexOf(7));
    }

    @Test
    public void testSize() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void testClear() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.clear();
        assertEquals("", linkedList.toString());
    }

    @Test
    public void testIsEmpty() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        assertArrayEquals(arr, linkedList.toArray());
    }

    @Test
    public void testToString() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String str = linkedList.toString();
        String result = "12, 3.0, hello";
        assertEquals(result, str);
    }

    @Test
    public void testAddFirst() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.addFirst(0);
        String result = "0, 12, 3.0, hello";

        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testAddLast() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.addLast(0);
        String result = "12, 3.0, hello, 0";

        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testGetFirst() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        int result = 12;

        assertEquals(result, linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        String result = "hello";

        assertEquals(result, linkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.removeFirst();
        String result = "3.0, hello";

        assertEquals(result, linkedList.toString());
    }

    @Test
    public void testRemoveLast() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(arr);
        linkedList = (ImmutableLinkedList) linkedList.removeLast();
        String result = "12, 3.0";

        assertEquals(result, linkedList.toString());
    }
}

package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testConstructor() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
    }

    @Test
    public void testAddObject() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.add(0);
        String result = "12, 3.0, hello, 0";

        assertEquals(result, arrList.toString());
    }

    @Test
    public void testInsertObject() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.add(2, 0);
        String result = "12, 3.0, 0, hello";

        assertEquals(result, arrList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertObjectException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.add(7, 0);
    }

    @Test
    public void testAddAll() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        Object[] addition = {0, "end"};
        arrList = (ImmutableArrayList) arrList.addAll(addition);
        String result = "12, 3.0, hello, 0, end";

        assertEquals(result, arrList.toString());
    }

    @Test
    public void testInsertAll() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        Object[] addition = {0, "end"};
        arrList = (ImmutableArrayList) arrList.addAll(2, addition);
        String result = "12, 3.0, 0, end, hello";

        assertEquals(result, arrList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAllException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        Object[] addition = {0, "end"};
        arrList = (ImmutableArrayList) arrList.addAll(-2, addition);
    }

    @Test
    public void testRemove() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.remove(1);
        String result = "12, hello";

        assertEquals(result, arrList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.remove(3);
    }

    @Test
    public void testGet() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        String result = "hello";

        assertEquals(result, arrList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.get(100);
    }

    @Test
    public void testSet() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.set(2, "new");
        String result = "12, 3.0, new";

        assertEquals(result, arrList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.set(-1, 0);
    }

    @Test
    public void testIndexOf() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        assertEquals(2, arrList.indexOf("hello"));
    }

    @Test
    public void testIndexOfNotFound() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        assertEquals(-1, arrList.indexOf(7));
    }

    @Test
    public void testSize() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        assertEquals(3, arrList.size());
    }

    @Test
    public void testClear() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        arrList = (ImmutableArrayList) arrList.clear();
        assertEquals("", arrList.toString());
    }

    @Test
    public void testIsEmpty() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        assertFalse(arrList.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        assertArrayEquals(arr, arrList.toArray());
    }

    @Test
    public void testToString() {
        Object[] arr = {12, 3.0, "hello"};
        ImmutableArrayList arrList = new ImmutableArrayList(arr);
        String str = arrList.toString();
        String result = "12, 3.0, hello";
        assertEquals(result, str);
    }

}

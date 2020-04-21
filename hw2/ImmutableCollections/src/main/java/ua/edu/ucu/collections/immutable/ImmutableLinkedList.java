package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList{
    private Node head;
    private int length;

    public ImmutableLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public ImmutableLinkedList(Object[] arr) {
        if (arr.length != 0) {
            this.head = new Node(arr[0]);
            Node curr = this.head;
            for (int i = 1; i < arr.length; i++) {
                curr.next = new Node(arr[i]);
                curr = curr.next;
            }
        }
        length = arr.length;
    }


    //Write copy method and index getter for Node!!!!!!!!!!
    private ImmutableLinkedList copy() {
        if (length == 0)
            return new ImmutableLinkedList();
        ImmutableLinkedList copyList = new ImmutableLinkedList();
        copyList.head = new Node(head.data);
        Node curr = head.next;
        Node currCopy = copyList.head;
        while (curr != null) {
            currCopy.next = new Node(curr.data);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        copyList.length = length;
        return copyList;
    }

    private Node getNode(int index) {
        if (index > length || index < 0 || length == 0)
            throw new IndexOutOfBoundsException();
        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr;
    }

    private void checkIndex(int index) {
        if (index > length || index < 0)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(length, e);
    }


    @Override
    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList resultList = copy();
        if (index == 0)
            resultList.head = new Node(e, resultList.head);
        else {
            Node previous = resultList.getNode(index - 1);
            previous.next = new Node(e, previous.next);
        }
        resultList.length = length + 1;
        return resultList;
    }


    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index);
        ImmutableLinkedList resultList = copy();
        resultList.head = new Node(null, resultList.head);
        if (c.length > 0) {
            Node curr = resultList.getNode(index);
            for (Object obj : c) {
                curr.next = new Node(obj, curr.next);
                curr = curr.next;
            }
        }
        resultList.head = resultList.head.next;
        return resultList;
    }

    @Override
    public Object get(int index) {
        return getNode(index).data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList resultList = copy();
        if (index == 0)
            resultList.head = resultList.head.next;
        else {
            Node previous = resultList.getNode(index - 1);
            previous.next = previous.next.next;
        }
        resultList.length = length - 1;
        return resultList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        ImmutableLinkedList resultList = copy();
        resultList.getNode(index).data = e;
        return resultList;
    }

    @Override
    public int indexOf(Object e) {
        Node curr = head;
        for (int i = 0; i < length; i++) {
            if (curr.data.equals(e))
                return i;
            curr = curr.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[length];
        Node curr = head;
        for (int i = 0; i < length; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    public String toString() {
        if (head == null)
            return "";
        StringBuilder result = new StringBuilder(head.data.toString());
        Node curr = head.next;
        while (curr != null) {
            result.append(", ").append(curr.data.toString());
            curr = curr.next;
        }
        return result.toString();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(length - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(length - 1);
    }



    private static class Node {
        private Object data;
        private Node next;

        private Node(Object obj) {
            data = obj;
            next = null;
        }

        private Node(Object obj, Node nextNode) {
            data = obj;
            next = nextNode;
        }

    }



    
}

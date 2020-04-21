package ua.edu.ucu.tries;


public class Queue<T> {
    private Node<T> head;
    private int size = 0;

    public Queue() {}

    public void enqueue(T data) {
        head = new Node<T>(data, head);
        size++;
    }

    public Object dequeue() {
        Node<T> curr = head;
        Node<T> prev = null;
        size--;
        if (head.getNext() == null) {
            head = null;
            return curr.getData();
        }

        while(curr.getNext() != null) {
            prev = curr;
            curr = curr.getNext();
        }
        curr = prev.getNext();
        prev.setNext(null);
        return curr.getData();

    }

    public String[] toArray() {
        String[] arr = new String[size];
        int i = 0;
        Node<T> curr = head;
        while (curr != null) {
            arr[i] = (String) curr.getData();
            i++;
            curr = curr.getNext();
        }
        return arr;
    }


    static class Node<T> {
        private T data;
        private Node<T> next;


        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}

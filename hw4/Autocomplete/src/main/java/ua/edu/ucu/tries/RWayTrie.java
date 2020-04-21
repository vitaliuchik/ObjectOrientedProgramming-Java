package ua.edu.ucu.tries;

import java.util.Arrays;
import java.util.Comparator;

public class RWayTrie implements Trie {
    private static int R = 256;
    private Node head;

    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }


    @Override
    public void add(Tuple t) {
        if (t.weight < 2)
            return;
        head = add(head, t.term, t.weight, 0);
    }
    private Node add(Node x, String key, int val, int d) {
        if (x == null)
            x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = add(x.next[c], key, val, d+1);
        return x;
    }


    @Override
    public boolean contains(String word) {
        return get(head, word, 0) != null;
    }
    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    @Override
    public boolean delete(String word) {
        boolean result = contains(word);
        head = delete(head, word, 0);
        return result;
    }
    private Node delete(Node x, String key, int d) {
        if (x == null)
            return null;
        if (key.length() == d)
            x.val = null;
        else
        {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != null) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }

    @Override
    public Iterable<String> words() {
        return wordsWithPrefix("");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Queue<String> q = new Queue<String>();
        collect(get(head, s, 0), s, q);
        String[] result = Arrays.copyOf(q.toArray(), q.toArray().length, String[].class);
        Arrays.sort(result, Comparator.comparingInt(String::length));
        return () -> Arrays.stream(result).iterator();

    }
    private void collect(Node x, String s, Queue<String> q) {
        if (x == null)
            return;
        if (x.val != null)
            q.enqueue(s);
        for (char c = 0; c < R; c++)
            collect(x.next[c], s + c, q);
    }





    @Override
    public int size() {
        return size(head);
    }
    private int size(Node x) {
        if (x == null)
            return 0;
        int counter = 0;
        if (x.val != null)
            counter++;
        for (char c = 0; c < R; c++)
            counter += size(x.next[c]);
        return counter;
    }


}


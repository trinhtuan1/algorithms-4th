package chapter3.section1;

import edu.princeton.cs.algs4.Queue;

import java.util.Scanner;

public class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;
    private class Node {
        private Key key;
        private Value val;
        private Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument of contains() is null");
        return get(key) != null;
    }
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument of get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument of put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) { x.val = val; return; }
        }
        first = new Node(key, val, first);
        n++;
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument of delete() is null");
        first = delete(first, key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            String key = scanner.next();
            st.put(key, i++);
        }
        for (String key : st.keys()) {
            System.out.println(key + " " + st.get(key));
        }
    }
}

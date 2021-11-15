package chapter3.section1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> {
    private TreeMap<Key, Value> st;
    ST() {
        st = new TreeMap<Key, Value>();
    }
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls set() with null key");
        if (val == null) st.remove(key);
        st.put(key, val);
    }
    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("calls remove() with null key");
        st.remove(key);
    }
    public boolean contains(Key key) {
        if(key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }
    public int size() {
        return st.size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("symbol table empty");
        return st.firstKey();
    }
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("symbol table empty");
        return st.lastKey();
    }
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("calls floors() with null key");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("key too small");
        return k;
    }
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("calls ceiling() with null key");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("key too large");
        return k;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(scanner.hasNext()) {
            String word = scanner.next();
            st.put(word, i++);
        }
        for(String word : st.keys()) {
            System.out.println(word + " " + st.get(word));
        }
    }
}

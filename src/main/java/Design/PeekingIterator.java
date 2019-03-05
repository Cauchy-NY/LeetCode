package Design;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer integer;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (integer == null && iterator.hasNext())
            integer = iterator.next();
        return integer;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (integer != null) {
            Integer res = integer;
            integer = null;
            return res;
        } else
            return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return integer != null || iterator.hasNext();
    }
}
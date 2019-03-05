package Medium;

import Design.PeekingIterator;

import java.util.ArrayList;
import java.util.List;

public class Question284 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        PeekingIterator peekingIterator = new PeekingIterator(integerList.iterator());
        peekingIterator.next();
        peekingIterator.peek();
        peekingIterator.next();
        peekingIterator.next();
        peekingIterator.hasNext();
    }
}

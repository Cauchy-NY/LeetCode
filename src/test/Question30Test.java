package test;

import Hard.Question30;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question30Test {

    Question30 q = new Question30();

    @Test
    public void test1() {
        List<Integer> result = new ArrayList<>();
        assertEquals(result, q.findSubstring("abcecekk",
                new String[] {"ab", "ce", "ss"}));
    }

    @Test
    public void test2() {
        List<Integer> result = new ArrayList<>();
        result.add(8);
        assertEquals(result, q.findSubstring("wordgoodgoodgoodbestword",
                new String[] {"word", "good", "best", "good"}));
    }

}

package test;

import Medium.Question17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Question17Test {

    Question17 q = new Question17();

    @Test
    public void test1() {
        assertEquals(Arrays.asList(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"})
                , q.letterCombinations("23"));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList(new String[]{})
                , q.letterCombinations(""));
    }
}

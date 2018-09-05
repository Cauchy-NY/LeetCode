package test;

import Medium.LongestSubstringWithoutRepeatingCharacters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void test1() {
        assertEquals(3, ls.lengthOfLongestSubstring("abc"));
    }

    @Test
    public void test2() {
        assertEquals(1, ls.lengthOfLongestSubstring("bbbb"));
    }

    @Test
    public void test3() {
        assertEquals(3, ls.lengthOfLongestSubstring("pwwkew"));
    }

}

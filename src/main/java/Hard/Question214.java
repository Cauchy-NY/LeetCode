package Hard;

public class Question214 {
    /**
     * 这是一个神奇的方法，感觉评论区没有人能很清楚的 explain why it works，下面摘录了一个收藏较多的解释
     * 之所以不直接返回 new StringBuffer(suffix).reverse().toString() + s，考虑这种情况"adcba"
     *
     * My thought is:
     * 1. if s is palindrome, after the loop, j will be j == s.length(),
     * then, we just need to return this palindrome string.
     * 2. if s overall is not padindrom, first, j will definitely be smaller
     * than s.length() - this is very import to ensure the recursion will
     * terminate at the base case - palindrome found or empty string found,
     * we will definitely cut the string “s” into two parts.
     * if s has some precedine substring to be palindrome, like “abbacdefg”,
     * j will definitely ended with somewhere after the “sub” palindrome - “abba”.
     * Thus, it is still safe for us to cut into two parts. Thus, this method works.
     */
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j))
                j++;
        }
        if (j == s.length())
            return s;
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    // kmp
    public String shortestPalindrome_2(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private int[] getTable(String s){
        //get lookup table
        int[] table = new int[s.length()];
        //pointer that points to matched char in prefix part
        int index = 0;
        //skip index 0, we will not match a string with itself
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            } else {
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];

                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if (s.charAt(index) == s.charAt(i)) {
                    //if match, then extend one char
                    index++;
                }

                table[i] = index;
            }

        }
        return table;
    }

    // 自己的辣鸡解法
    public String shortestPalindrome_3(String s) {
        int index = s.length();
        while (!isPalindrome(s.substring(0, index)))
            index--;
        String head = s.substring(index);
        return new StringBuilder(head).reverse().toString()+s;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Question214().shortestPalindrome("adcba"));
    }
}

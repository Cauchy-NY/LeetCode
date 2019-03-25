package Medium;

public class Question318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int[] value = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            // 整个解法的精华部分
            // bitwise bucket
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++)
                // 将1左移(tmp.charAt(j) - 'a')位
                value[i] |= 1 << (tmp.charAt(j) - 'a');
//            // 帮助理解
//            System.out.println(tmp+"->"+value[i]+ "->"+Integer.toBinaryString(value[i]) );
        }

        int maxProduct = 0, tmpProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0 && ((tmpProduct = words[i].length() * words[j].length()) > maxProduct))
                    maxProduct = tmpProduct;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","c","d","e","f","ab","ac","bc","abc"};
        new Question318().maxProduct(words);
    }
}

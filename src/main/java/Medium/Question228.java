package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        int begin = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1)
                end = nums[i];
            else {
                addRange(result, begin, end);
                begin = end = nums[i];
            }
        }
        addRange(result, begin, end);
        return result;
    }

    private void addRange(List<String> result, int begin, int end) {
        if (begin == end)
            result.add(String.valueOf(begin));
        else
            result.add(begin + "->" + end);
    }
}

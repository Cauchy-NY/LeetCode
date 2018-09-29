package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] isTake = new boolean[nums.length];
        trackback(res, tmp, nums, isTake);
        return res;
    }

    private void trackback(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] isTake) {
        for (int i = 0; i < isTake.length; i++) {
            if (!isTake[i]) {
                isTake[i] = !isTake[i];
                tmp.add(nums[i]);
                trackback(res, tmp, nums, isTake);
                tmp.remove(tmp.size()-1);
                isTake[i] = !isTake[i];
                continue;
            }
        }
        boolean isExist = false;
        if (tmp.size() == nums.length)
            res.add(new ArrayList<>(tmp));
    }

    public static void main(String[] main) {
        Question46 q = new Question46();
        int[] nums = new int[] {1, 1, 3};
        List<List<Integer>> res = q.permute(nums);
        for (List<Integer> list: res) {
            for (int i: list)
                System.out.print(i);
            System.out.println();
        }
    }
}

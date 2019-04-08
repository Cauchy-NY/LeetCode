package Hard;

public class Question330 {
    // 首先假设我们能表示[0, k)的数，但是给定数组的下一个是m，m>k，那么[k, m)直接的数表示不了
    // 那么我们往数组里面加上一个k，因为我们已经能组合出[0, k)，那么肯定可以组合出[k, 2k)
    // 所以现在的范围是[0, 2k)，但是若数组中的下一个数m，k<m<2k
    // 那么加入k之后不需要加上2k，因为现在能组合出[0, 2k)，所以使用m之后范围变为[0, 2k+m)
    // 令2k+m=k，重复第一步知道k>n
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }
        return added;
    }
}

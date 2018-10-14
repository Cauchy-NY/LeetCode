package Medium;

import java.util.Arrays;

public class Question60 {
    public String getPermutation(int n, int k) {
        int[] pers = new int[n];
        // init
        for (int i = 0; i < pers.length; i++)
            pers[i] = i+1;
        int index = 1;
        while (index < k) {
            int i = n-1, j = n-1;
            // 从右向左寻找非递减序列,例如对于序列1,3,5,4,2,将会找到数字5的位置
            for (; i > 0 && pers[i] <= pers[i-1]; i--);
            // 例:对于5,4,3,2,1的情形，他的下一个不存在
            if (i == 0)
                break;
            // 从非递减序列李寻找比它前面的一个数(3)大的最小数,即数字4
            for (; pers[j] <= pers[i-1]; j--);
            // 交换3和4
            swap(pers, i-1, j);
            Arrays.sort(pers, i, n);

            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i: pers)
            sb.append(i);
        return sb.toString();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String...args) {
        System.out.println(new Question60().getPermutation(3, 3));
    }
}

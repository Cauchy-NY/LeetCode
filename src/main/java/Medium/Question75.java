package Medium;

public class Question75 {
    public void sortColors(int[] nums) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count1++;
            if (nums[i] == 2)
                count2++;
        }
        int index = nums.length-1;
        while (index >= 0) {
            if (count2 > 0) {
                nums[index] = 2;
                count2--;
            }
            else if (count1 > 0 && count2 == 0) {
                nums[index] = 1;
                count1--;
            }
            else if (count1 == 0 && count2 == 0)
                nums[index] = 0;
            index--;
        }
    }
//    // mdzz
//    public void sortColors(int[] nums) {
//        int left = 0, right = nums.length-1;
//        flag: for (int i = 0; i <= right; i++) {
//            if (i == right && nums[i] == 2)
//                break;
//            if (nums[i] == 2) {
//                while (nums[right] == 2) {
//                    right--;
//                    if (right <= left)
//                        break flag;
//                }
//                swap(nums, i, right);
//                right--;
//                i--;
//                continue;
//            }
//            if (nums[i] == 0) {
//                while (nums[left] == 0) {
//                    left++;
//                    if (left >= right)
//                        break flag;
//                }
//                if (left > i)
//                    i = left-1;
//                else {
//                    swap(nums, left, i);
//                    left++;
//                    i--;
//                }
//                continue;
//            }
//        }
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

    public static void main(String...args) {
//        new Question75().sortColors(new int[] {2,0,2,1,1,0});
        new Question75().sortColors(new int[] {1,1,2});
    }
}

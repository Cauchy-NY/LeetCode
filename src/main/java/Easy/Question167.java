package Easy;

public class Question167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0)
            return res;
        for (int i = 0, j = numbers.length-1; i < j;) {
            if (numbers[i] + numbers[j] == target) {
                res[0] = i+1;
                res[1] = j+1;
                break;
            } else if (numbers[i] + numbers[j] > target)
                j--;
            else
                i++;
        }
        return res;
    }
}

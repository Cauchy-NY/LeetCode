package Hard;
import java.util.*;

public class Question315 {
    // 更直观的线段树版本
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(TreeNode root, int val) {
        int thisCount = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else
                    root = root.left;
            } else {
                thisCount += root.count;
                if(root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else
                    root = root.right;
            }
        }
        return thisCount;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int count = 1;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 线段树，时间复杂度O(nlogn)
    public List<Integer> countSmaller_2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        Node root = new Node(min, max);
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length-1; i >= 0; i--)
            res[i] = smaller(root, nums[i]);
        return Arrays.asList(res);
    }

    private int smaller(Node node, int val) {
        node.count++;
        if (node.min == node.max) return 0;
        int m = (node.min + node.max) / 2;
        if (m < val) {
            if (node.right == null) node.right = new Node(m+1, node.max);
            return (node.count-1) - node.right.count + smaller(node.right, val);
        } else if (m > val) {
            if (node.min == m) return 0;
            if (node.left == null) node.left = new Node(node.min, m-1);
            return smaller(node.left, val);
        } else {
            if (node.left == null) return 0;
            return node.left.count;
        }
    }

    class Node {
        int min, max;
        int count;
        Node left, right;
        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    // 二分插入之前已排序部分(倒序排列)，下标即是结果
    // 时间是O(2nlogn)
    public List<Integer> countSmaller_3(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Integer[] res = new Integer[nums.length];
        res[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            // 二分查找
            int left = i+1, right = nums.length-1;
            while (left <= right) {
                int mid = (left+right) / 2;
                if (nums[i] > nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            // 下标即结果
            res[i] = nums.length - left;
            // 插入
            int temp = nums[i];
            for (int j = i; j < right; j++)
                nums[j] = nums[j+1];
            nums[right] = temp;
        }
        return Arrays.asList(res);
    }

    // 时间复杂度O(n^2) TLE
    public List<Integer> countSmaller_4(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return res;

        res.add(0);
        for (int i = nums.length-2; i >= 0; i--) {
            int tmpCnt = 0;
            for (int j = nums.length-1; j > i; j--) {
                if (nums[i] > nums[j])
                    tmpCnt++;
            }
            res.add(0, tmpCnt);
        }
        return res;
    }
}

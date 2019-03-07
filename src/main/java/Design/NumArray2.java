package Design;

/**
 * NumArray 的数组可变版本
 */
public class NumArray2 {

    private SegmentTreeNode root = null;

    public NumArray2(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
}
// 照着前面的NumArray思路实现，在update较多情况下性能不好
//public class NumArray2 {
//
//    private int[] nums;
//
//    public NumArray2(int[] nums) {
//        for (int i = 1; i < nums.length; i++)
//            nums[i] += nums[i-1];
//        this.nums = nums;
//    }
//
//    public void update(int i, int val) {
//        for (int j = nums.length-1; j > i; j--)
//            nums[j] -= nums[j-1];
//        nums[i] = val;
//        for (int j = i == 0 ? 1 : i; j < nums.length; j++)
//            nums[j] += nums[j-1];
//    }
//
//    public int sumRange(int i, int j) {
//        return i == 0 ? nums[j] : nums[j] - nums[i-1];
//    }
//}

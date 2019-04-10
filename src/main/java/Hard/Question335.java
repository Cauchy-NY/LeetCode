package Hard;

public class Question335 {
    // 1.从螺旋减小再到螺旋增大，这种状态必然是相交的。
    // 2.从螺旋增大再到螺旋减小，这种状态并不一定相交，但是会改变x[i-1]的边界条件：
    //   即我们需要判断x[i] + x[i - 4]是否比x[i-2]小，如果小的话，则x[i-1]的边界不会变；
    //   但是如果x[i] + x[i - 4] >= x[i-2]，x[i-1]将会减小为x[i-1] - x[i-3]
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3)
            return false;

        boolean flag = x[2] > x[0];  // 螺旋增加或者减少的标志，true为增加
        for (int i = 3; i < x.length; i++) {
            if (!flag && x[i] >= x[i-2])
                return true;
            if (flag && x[i] <= x[i-2]) {
                flag = false;
                x[i-1] = (x[i] + (i >= 4 ? x[i-4] : 0)) < x[i-2] ? x[i-1] : (x[i-1] - x[i-3]);
            }
        }
        return false;
    }

//    // 只考虑了螺旋增加，没考虑螺旋减少
//    public boolean isSelfCrossing(int[] x) {
//        int m = 0, n = 0;  // point
//        int[] border = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
//        for (int i = 0; i < x.length; i++) {
//            switch (i%4) {
//                case 0: {
//                    m += x[i];
//                    if (m <= border[0]) return true;
//                    else border[0] = m;
//                    break;
//                }
//                case 1: {
//                    n -= x[i];
//                    if (n >= border[1]) return true;
//                    else border[1] = n;
//                    break;
//                }
//                case 2: {
//                    m -= x[i];
//                    if (m >= border[2]) return true;
//                    else border[2] = m;
//                    break;
//                }
//                case 3: {
//                    n += x[i];
//                    if (n <= border[3]) return true;
//                    else border[3] = n;
//                }
//            }
//
//        }
//        return false;
//    }

    public static void main(String[] args) {
        new Question335().isSelfCrossing(new int[]{3,3,4,2,2});
    }
}

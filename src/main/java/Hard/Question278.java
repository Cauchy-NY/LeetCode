package Hard;

public class Question278 {
    class VersionControl {
        public boolean isBadVersion(int version) {
            return version > 3;
        }
    }

    class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n;
            while (left < right) {
                int mid = left + (right-left) / 2;
                if (!isBadVersion(mid)) left = mid + 1;
                else right = mid;
            }
            return left;
        }

        // TLE
        public int firstBadVersion_2(int n) {
            int left = 1, right = n, mid;
            boolean isMidBad, isMidBeforeBad;
            while (left <= right) {
                mid = (left+right) / 2;
                isMidBad = isBadVersion(mid);
                isMidBeforeBad = isBadVersion(mid-1);
                if (isMidBad) {
                    if (isMidBeforeBad) right = mid-1;
                    else return mid;
                } else
                    left = mid+1;
            }
            return 0;
        }
    }
}

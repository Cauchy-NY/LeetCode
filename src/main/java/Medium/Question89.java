package Medium;

import java.util.ArrayList;
import java.util.List;

public class Question89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        List<Integer> lastRes = grayCode(n-1);
        int addTmp = (int) Math.pow(2, n-1); // 最高位+1
        for (int i = lastRes.size()-1; i >= 0; i--)
            lastRes.add(lastRes.get(i) + addTmp);
        return lastRes;
    }
}

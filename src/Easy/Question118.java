package Easy;

import java.util.ArrayList;
import java.util.List;

public class Question118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1)
            return res;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> eachRow = new ArrayList<>();
            eachRow.add(1);
            for (int j = 1; j < i; j++)
                eachRow.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            eachRow.add(1);
            res.add(eachRow);
        }
        return res;
    }
}

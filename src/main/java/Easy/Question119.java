package Easy;

import java.util.ArrayList;
import java.util.List;

public class Question119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        if (rowIndex == 0)
            return firstRow;

        for (int i = 1; i < rowIndex; i++) {
            List<Integer> eachRow = new ArrayList<>();
            eachRow.add(1);
            for (int j = 1; j < i; j++)
                eachRow.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            eachRow.add(1);
            res.add(eachRow);
        }

        return res.get(rowIndex-1);
    }
//    // 会溢出
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i <= rowIndex; i++)
//            res.add(nCr(rowIndex, i));
//        return res;
//    }
//
//    private int nCr(int n, int r) {
//        return (int) (nAr(n, r) / nAr(r, r));
//    }
//
//    private long nAr(int n, int r) {
//        long result = 1;
//        for (int i = r; i > 0; i--) {
//            result *= n;
//            n--;
//        }
//        return result;
//    }

    public static void main(String...args) {
//        System.out.println(new Question119().nCr(18, 9));
    }
}

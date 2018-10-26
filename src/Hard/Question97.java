package Hard;

public class Question97 {
    // 典型的dp都没看出开orz
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length()+s2.length())!=s3.length())
            return false;

        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];
        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++)
            matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));

        for (int i = 1; i < matrix.length; i++)
            matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
        }

        return matrix[s2.length()][s1.length()];
    }

//    TLE 99/101 orz
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != s1.length() + s2.length())
//            return false;
//        else {
//            int p1 = 0, p2 = 0, p3 = 0;
//            while (p1 != s1.length() && p2 != s2.length() && p3 != s3.length()) {
//                if (s1.charAt(p1) != s3.charAt(p3) && s2.charAt(p2) != s3.charAt(p3))
//                    return false;
//                else {
//                    if (s1.charAt(p1) != s3.charAt(p3)) {
//                        p2++;
//                        p3++;
//                    }
//                    else if (s2.charAt(p2) != s3.charAt(p3)) {
//                        p1++;
//                        p3++;
//                    }
//                    else
//                        return isInterleave(s1.substring(++p1, s1.length()), s2.substring(p2, s2.length()), s3.substring(++p3, s3.length()))
//                                || isInterleave(s1.substring(--p1, s1.length()), s2.substring(++p2, s2.length()), s3.substring(p3, s3.length()));
//                }
//            }
//            if (p1 == s1.length())
//                return s3.substring(p3, s3.length()).equals(s2.substring(p2, s2.length()));
//            if (p2 == s2.length())
//                return s3.substring(p3, s3.length()).equals(s1.substring(p1, s1.length()));
//        }
//        return true;
//    }

    public static void main(String...args) {
        new Question97().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        new Question97().isInterleave("a", "", "c");
    }
}

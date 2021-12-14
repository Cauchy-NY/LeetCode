package Others;

public class Question05_KMP {

    public void printFailArray(int[] fail) {
        for (int num: fail) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[] fail(String pattern) {
        int len = pattern.length();
        int[] fail = new int[len];

        fail[0] = 0;
        for (int i = 0, j = 1; j < len; j++) {
            while (pattern.charAt(i) != pattern.charAt(j) && i > 0) {
                i = fail[i - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i))
                i++;
            else
                i = 0;
            fail[j] = i;
        }

        return fail;
    }

    public int kmp(String str, String pattern) {
        int sCur = 0, pCur = 0;
        int sLen = str.length(), pLen = pattern.length();
        int[] fail = fail(pattern);

        while (sCur < sLen && pCur < pLen) {
            if (str.charAt(sCur) == pattern.charAt(pCur)) {
                sCur++;
                pCur++;
            } else if (pCur == 0)
                sCur++;
            else
                pCur = fail[pCur - 1];
        }
        return pCur == pLen ? sCur - pLen : -1;
    }

    public static void main(String[] args) {
        Question05_KMP kmp = new Question05_KMP();

        kmp.printFailArray(kmp.fail("ABCDABD"));
        System.out.println(kmp.kmp("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));

        kmp.printFailArray(kmp.fail("aaaab"));
        System.out.println(kmp.kmp("aaac aaaab", "aaaab"));
    }
}

package Medium;

public class Question165 {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }
        return 0;
    }

//    public int compareVersion(String version1, String version2) {
//        if (version1 == null || version1.equals("")
//                || version2 == null || version2.equals(""))
//            return 0;
//
//        String[] verStr1 = version1.split("[.]");
//        String[] verStr2 = version2.split("[.]");
//        int len = Math.max(verStr1.length, verStr2.length);
//
//        int[] ver1 = copyArray(verStr1, len);
//        int[] ver2 = copyArray(verStr2, len);
//        int cur = 0;
//        while (cur < len && ver1[cur] == ver2[cur])
//            cur++;
//
//        if (cur == len)
//            return 0;
//        else if (ver1[cur] > ver2[cur])
//            return 1;
//        else
//            return -1;
//    }
//
//    private int[] copyArray(String[] array, int len) {
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) {
//            if (i >= array.length)
//                res[i] = 0;
//            else
//                res[i] = Integer.parseInt(array[i]);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        new Question165().compareVersion("1.0.0", "1.0");
    }
}

package Medium;

public class Question275 {
    public int hIndex(int[] citations) {
        int left = 0, right= citations.length-1,  mid;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (citations[mid] >= (citations.length-mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return citations.length - left;
    }

    public int hIndex_2(int[] citations) {
        int h = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i] >= citations.length-i) h++;
            else break;
        }
        return h;
    }
}

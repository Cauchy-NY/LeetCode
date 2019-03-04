package Medium;

public class Question274 {
    // 基本想法差不多，但是是不需要排序的，我一开始想的不周到
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];

        for (int c: citations) {
            if (c > citations.length)
                count[citations.length]++;
            else
                count[c]++;
        }

        int total = 0;
        for (int i = citations.length; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }

        return 0;
    }

    public int hIndex_2(int[] citations) {
        qsort(citations, 0, citations.length-1);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i+1) h++;
            else break;
        }
        return h;
    }

    private static void qsort(int[] arr, int low, int high){
        if (low >= high)
            return;

        int pivot = partition(arr, low, high);
        qsort(arr, low, pivot-1);
        qsort(arr, pivot+1, high);
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= pivot)
                --high;
            arr[low] = arr[high];
            while (low < high && arr[low] >= pivot)
                ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] citations = new int[] {3,0,6,1,5};
        System.out.println(new Question274().hIndex(citations));
    }
}

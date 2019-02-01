package Hard;

import java.util.ArrayList;
import java.util.List;

public class Question4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        else if(nums1.length == 0) {
            if(nums2.length % 2 == 0)
                return (nums2[nums2.length/2-1] + nums2[nums2.length/2])/2.0;
            else
                return nums2[nums2.length/2];
        }
        else if(nums2.length == 0) {
            if(nums1.length % 2 == 0)
                return (nums1[nums1.length/2-1] + nums1[nums1.length/2])/2.0;
            else
                return nums1[nums1.length/2];
        }
        else {
            int i = 0, j = 0;
            List<Integer> list = new ArrayList<>();
            int medium = (nums1.length + nums2.length)/2;

            while (i+j-1 != medium && i < nums1.length && j < nums2.length) {
                if(nums1[i] > nums2[j]) {
                    list.add(nums2[j]);
                    j++;
                }
                else {
                    list.add(nums1[i]);
                    i++;
                }
            }

            if(i+j-1 != medium) {
                if(i == nums1.length) {
                    while(i+j-1 != medium) {
                        list.add(nums2[j]);
                        j++;
                    }
                }
                else {
                    while(i+j-1 != medium) {
                        list.add(nums1[i]);
                        i++;
                    }
                }
            }

            if((nums1.length + nums2.length) % 2 == 0) {
                return (list.get(list.size()-1) + list.get(list.size()-2))/2.0;
            }
            else {
                return list.get(list.size()-1);
            }
        }
    }
}

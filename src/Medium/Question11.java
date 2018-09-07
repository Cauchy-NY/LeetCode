package Medium;

public class Question11 {
    public int maxArea(int[] height) {
        int max = 0;
        if(height.length > 1) {
            for(int i = 0; i < height.length; i++) {
                for(int j = i+1; j < height.length; j++) {
                    if((j-i) * (height[j] > height[i] ? height[i]: height[j]) > max)
                        max = (j-i) * (height[j] > height[i] ? height[i]: height[j]);
                }
            }
        }
        return max;
    }
}

class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        
        int l =0;
        int r = height.length -1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int sum = 0;

        while(l<r) {
            if(maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                sum += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                sum += maxRight - height[r];
            }
        }

        return sum;
    }
}

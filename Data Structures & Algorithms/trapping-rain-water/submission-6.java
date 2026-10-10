class Solution {
    public int trap(int[] height) {
      if(height == null || height.length < 2) {
        return 0;
      }

      int left = 0;
      int right = height.length - 1;
      int leftMax = height[left];
      int rightMax = height[right];
      int totalWater = 0;

      while(left < right) {
        if(leftMax < rightMax) {
            left++;
            leftMax = Math.max(leftMax, height[left]);
            totalWater += leftMax - height[left];    
        } else {
            right--;
            rightMax = Math.max(rightMax, height[right]);
            totalWater += rightMax - height[right];     
        }
      }
      return totalWater;
    }
}

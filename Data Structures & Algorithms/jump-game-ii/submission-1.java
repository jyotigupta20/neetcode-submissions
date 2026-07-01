class Solution {
    public int jump(int[] nums) {

if(nums.length <= 1) {
    return 0;
}
       int maxReach = 0;
       int currReach = 0;
       int jumpCount = 0;

        for(int i=0; i < nums.length; i++) {
                

            if(i > maxReach) {
                return 0;
            }

            maxReach = Math.max(maxReach, i+nums[i]);

            if(i == currReach) {
                jumpCount++;
                currReach = maxReach;
                if(maxReach >= nums.length-1) {
                    return jumpCount;
                }
            }
        }

        return jumpCount; 
    }
}

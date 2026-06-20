class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxLongest = 0;
        int curLongest = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                curLongest = 1;
                while(set.contains(num + curLongest)){
                    curLongest++;
                }
                maxLongest = Math.max(maxLongest, curLongest);
            }
        }
        return maxLongest;
    }
}

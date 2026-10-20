class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        List<Integer> subset = new ArrayList<>();
        subsets(nums, 0, subset, result);
        return result;
    }

    public void subsets(int[] nums, int currIndex, List<Integer> subset, List<List<Integer>> result) {
        if(currIndex >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[currIndex]);
        subsets(nums, currIndex+1, subset, result);
        subset.remove(subset.size()-1);
        subsets(nums, currIndex+1, subset, result);
    }
}

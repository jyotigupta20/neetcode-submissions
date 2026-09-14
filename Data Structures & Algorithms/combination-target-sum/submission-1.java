class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, 0, target, subset);
        return result;
    }

    void dfs(int[] nums, int currIndex, int currSum, int target, List<Integer> subset) {
        if(currSum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i=currIndex; i<nums.length; i++) {
            if(currSum + nums[i] > target) {
                return;
            }

            subset.add(nums[i]);
            dfs(nums, i, currSum + nums[i], target, subset);
            subset.remove(subset.size()-1);
        }

    }

}

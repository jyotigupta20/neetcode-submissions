class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, target, 0, 0, subset);
        return result;
    }

    void dfs(int[] candidates, int target, int currIndex, int currSum, List<Integer> subset) {
        if(currSum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i = currIndex; i<candidates.length; i++) {
            if(i > currIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] + currSum > target) {
                break;
            }
            subset.add(candidates[i]);
            dfs(candidates, target, i+1, candidates[i] + currSum , subset);
            subset.remove(subset.size()-1);
        }
    }
}

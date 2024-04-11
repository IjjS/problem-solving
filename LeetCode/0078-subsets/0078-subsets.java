class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        results.add(Collections.emptyList());
        
        dfs(nums, 0, new ArrayList<>(), results);
        
        return results;
    }
    
    private void dfs(int[] nums, int index, List<Integer> subsets, List<List<Integer>> results) {
        for (int i = index; i < nums.length; i++) {
            if (!subsets.contains(nums[i])) {
                subsets.add(nums[i]);
                results.add(new ArrayList<>(subsets));
                dfs(nums, i + 1, subsets, results);
                subsets.removeLast();
            }
        }
    }
}
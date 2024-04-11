class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(candidates, 0, 0, target, new ArrayList<>(), results);
        
        return results;
    }
    
    private void dfs(int[] candidates, int index, int sum, int target, List<Integer> combinations, List<List<Integer>> results) {
        if (sum == target) {
            results.add(new ArrayList<>(combinations));
            
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            int newSum = sum + candidates[i];
            
            if (newSum <= target) {
                combinations.add(candidates[i]);
                dfs(candidates, i, newSum, target, combinations, results);
                combinations.removeLast();
            }
        }
    }
}
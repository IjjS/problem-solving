class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(n, 1, k, new ArrayList<>(), results);
        
        return results;
    }
    
    private void dfs(int n, int index, int k, List<Integer> combinations, List<List<Integer>> results) {
        if (combinations.size() == k) {
            results.add(new ArrayList<>(combinations));
            
            return;
        }
        
        for (int i = index; i <= n; i++) {
            combinations.add(i);
            dfs(n, i + 1, k, combinations, results);
            combinations.removeLast();
        }
    }
}
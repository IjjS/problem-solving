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
            if (!combinations.contains(i)) {
                combinations.add(i);
                dfs(n, i + 1, k, combinations, results);
                combinations.remove(combinations.size() - 1);
            }
        }
    }
}

/* n = 4, k = 2
1, 2, 3, 4
-> 1 => 12, 13, 14
-> 2 => 23, 24
-> 3 => 34
-> 4 => X

size == k ? terminate

data = nums left from tha all num set in ascending order
order = smallest i -> greater
condition = size == k
collections = new int list
*/ 
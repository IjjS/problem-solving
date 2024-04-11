class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsLeft = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(numsLeft, new ArrayList<>(), results);
        
        return results;
    }
    
    private void dfs(List<Integer> numsLeft, List<Integer> newList, List<List<Integer>> results) {
        if (numsLeft.isEmpty()) {
            results.add(new ArrayList<>(newList));
            
            return;
        }
        
        for (Integer num : numsLeft) {
            List<Integer> newNumsLeft = new ArrayList<>(numsLeft);
            newNumsLeft.remove(num);
            newList.add(num);
            
            dfs(newNumsLeft, newList, results);
            
            newList.remove(num);
        }
    }
}
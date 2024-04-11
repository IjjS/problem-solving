class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> guides = new HashMap<>();
        List<Integer> regulars = new ArrayList<>();
        Set<Integer> checked = new HashSet<>();
        
        for (int[] prerequisite: prerequisites) {
            guides.computeIfAbsent(prerequisite[0], reg -> new ArrayList<>())
                .add(prerequisite[1]);
        }
        
        for (int prerequisite : guides.keySet()) {
            if (!dfs(guides, prerequisite, regulars, checked)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> guides, int prerequisite, List<Integer> regulars, Set<Integer> checked) {
        if (regulars.contains(prerequisite)) {
            return false;
        }
        
        if (checked.contains(prerequisite)) {
            return true;
        }
        
        checked.add(prerequisite);
        
        if (!guides.containsKey(prerequisite)) {
            return true;
        }
        
        regulars.add(prerequisite);
        
        for (int regular : guides.get(prerequisite)) {
            if (!dfs(guides, regular, regulars, checked)) {
                return false;
            }
        }
        
        regulars.removeLast();
        
        return true;
    }
}
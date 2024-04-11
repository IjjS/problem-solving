class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> guides = new HashMap<>();
        boolean[] regulars = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        
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
    
    private boolean dfs(Map<Integer, List<Integer>> guides, int prerequisite, boolean[] regulars, boolean[] checked) {
        if (regulars[prerequisite]) {
            return false;
        }
        
        if (checked[prerequisite]) {
            return true;
        }
        
        checked[prerequisite] = true;
        
        if (!guides.containsKey(prerequisite)) {
            return true;
        }
        
        regulars[prerequisite] = true;
        
        for (int regular : guides.get(prerequisite)) {
            if (!dfs(guides, regular, regulars, checked)) {
                return false;
            }
        }
        
        regulars[prerequisite] = false;
        
        return true;
    }
}
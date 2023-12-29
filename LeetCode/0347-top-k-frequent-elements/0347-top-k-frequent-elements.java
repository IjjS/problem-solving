class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elements = new HashMap<>();
        int[] kNums = new int[k];
        
        for (int i : nums) elements.put(i, elements.getOrDefault(i, 0) + 1);
        
        List<Integer> temp = elements.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(element -> element.getKey())
            .toList();
        
        for (int i = 0; i < temp.size(); i++) {
            if (i >= k) break;
            kNums[i] = temp.get(i);
        }
        
        return kNums;
    }
}
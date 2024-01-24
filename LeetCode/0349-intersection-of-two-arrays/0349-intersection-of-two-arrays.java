class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(nums1);
        
        for (int num : nums2) {
            int i = Arrays.binarySearch(nums1, num);
            
            if (i >= 0) set.add(num);
        }
        
        return set.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}
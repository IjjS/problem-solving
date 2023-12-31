class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        List<List<Integer>> triplets = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                
                if (sum < 0) left++;
                if (sum > 0) right--;
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                }
            }
        }
        
        return triplets;
    }
}
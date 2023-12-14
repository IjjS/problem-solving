class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int product = 1;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            answer[i] = product;
            product *= nums[i];
        }
        
        product = 1;
        
        for (int i = len - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }
        
        return answer;
    }
}
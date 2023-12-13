class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]
        var answer = 0
        
        while (left < right) {
            if (leftMax < rightMax) {
                left++
                leftMax = leftMax.coerceAtLeast(height[left])
                answer += (leftMax - height[left])
            } else {
                right--
                rightMax = rightMax.coerceAtLeast(height[right])
                answer += (rightMax - height[right])
            }
        }
        
        return answer
    }
}
class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < height.length; i++) {
            //facing inflection
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //store the last
                int last = stack.pop();
                
                if (stack.isEmpty()) continue;
                
                //distance between current and last stack (+1 for pop above)
                int distance = i - (stack.peek() + 1);
                
                //last inflection can be higher, so get the min height
                int h = Math.min(height[i], height[stack.peek()]) - height[last];
                
                //a = h*d;
                answer += distance * h;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}
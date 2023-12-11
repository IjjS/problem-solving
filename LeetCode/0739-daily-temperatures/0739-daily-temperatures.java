class Solution {
    Deque<Integer> stack = new ArrayDeque<>();
    
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty()) {
                while (stack.peek() != null && temperatures[stack.peek()] < temperatures[i]) {
                    answer[stack.peek()] = i - stack.pop();
                }
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}
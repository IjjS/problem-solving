class Solution {
    Map<Integer, Integer> dailyT = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            dailyT.put(i, temperatures[i]);
        }
        
        for (int i = 0; i < temperatures.length; i++) {
            if (!stack.isEmpty()) {
                while (stack.peek() != null && dailyT.get(stack.peek()) < temperatures[i]) {
                    answer[stack.peek()] = i - stack.pop();
                }
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}
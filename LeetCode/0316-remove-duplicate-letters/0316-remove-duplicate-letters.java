class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        boolean[] checked = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) counts[c - 'a']++;
        
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            
            counts[index]--;
            
            if (checked[index]) continue;
            
            checked[index] = true;
            
            while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] != 0) {
                checked[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse()
            .toString();
    }
}
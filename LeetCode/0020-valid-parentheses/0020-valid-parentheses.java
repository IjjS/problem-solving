class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> openers = new ArrayDeque<>();
        
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                openers.push(s.charAt(i));
            } else if (openers.isEmpty() || openers.pop() != map.get(s.charAt(i))) {
                return false;
            }
        }
        
        return openers.isEmpty();
    }
}
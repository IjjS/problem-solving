class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> rpt = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        
        for (char c : s.toCharArray()) {
            if (rpt.containsKey(c) && left <= rpt.get(c)) left = rpt.get(c) + 1;
            
            rpt.put(c, right);
            
            if (maxLen < right - left + 1) maxLen = right - left + 1;
            
            right++;
        }
        
        return maxLen;
    }
}
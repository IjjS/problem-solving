class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Map<Character, Integer> jewelsMap = new HashMap<>();
        
        for (char jewel : jewels.toCharArray()) {
            jewelsMap.put(jewel, jewelsMap.getOrDefault(jewel, 0) + 1);
        }
        
        for (char stone : stones.toCharArray()) {
            if (jewelsMap.containsKey(stone)) {
                answer++;
            }
        }
        
        return answer;
    }
}
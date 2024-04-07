class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Set<Character> freqs = new HashSet<>();
        
        for (char jewel : jewels.toCharArray()) {
            freqs.add(jewel);
        }
        
        for (char stone : stones.toCharArray()) {
            if (freqs.contains(stone)) {
                answer++;
            }
        }
        
        return answer;
    }
}
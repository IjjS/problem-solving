class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start: Int = 0
        var end: Int = 0
        var max: Int = 0
        val map: MutableMap<Char, Int> = mutableMapOf()
        
        s.forEach { ch ->
            if (map.containsKey(ch) && start <= map[ch]!!) {
                start = map[ch]!! + 1
            }
            
            map[ch] = end
            
            max = Math.max(max, end - start + 1)
            
            end++
        }
        
        return max
    }
}
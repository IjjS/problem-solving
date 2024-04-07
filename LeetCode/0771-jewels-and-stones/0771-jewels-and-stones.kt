class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var answer: Int = 0
        val freqs: MutableSet<Char> = HashSet()
        
        jewels.forEach{ jewel -> freqs.add(jewel) }
        stones.forEach{ stone ->
            if (freqs.contains(stone)) {
                answer++
            }
        }
        
        return answer
    }
}
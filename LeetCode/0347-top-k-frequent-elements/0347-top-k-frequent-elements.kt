class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()
        val pq: PriorityQueue<IntArray> = PriorityQueue { a: IntArray, b: IntArray ->
            b[1] - a[1]
        }
        val answer: IntArray = IntArray(k)
        
        nums.forEach { num -> map[num] = map.getOrDefault(num, 0) + 1 }
        
        for (key in map.keys) {
            pq.add(intArrayOf(key, map[key]!!))
        }
        
        for (i in 0 until k) {
            answer[i] = pq.poll()[0]
        }
        
        return answer
    }
}
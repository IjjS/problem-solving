class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String? {
        val map: MutableMap<String, Int> = mutableMapOf()
        val regex = Regex("\\W+")
        val words = paragraph.lowercase().split(regex)
        
        for (word in words) {
            if (word.isBlank()) continue;
            if (!banned.contains(word)) {
                map[word] = map.getOrDefault(word, 0) + 1
            }
        }
        
        return map.maxBy { it.value }.key
    }
}
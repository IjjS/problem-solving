class Solution {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String? {
        val map: MutableMap<String, Int> = mutableMapOf()
        val regex = Regex("\\W+")
        val words = paragraph.replace(regex, " ").toLowerCase().trim().split(" ")
        
        for (word in words) {
            if (!banned.contains(word)) {
                map[word] = map.getOrDefault(word, 0) + 1
            }
        }
        
        return map.maxBy { it.value }.key
    }
}
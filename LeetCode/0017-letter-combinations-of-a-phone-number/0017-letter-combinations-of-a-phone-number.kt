class Solution {
    fun letterCombinations(digits: String): List<String> {
        val results: MutableList<String> = mutableListOf()
        
        if (digits.isEmpty()) {
            return Collections.emptyList()
        }
        
        val map: Map<Char, Array<Char>> = mutableMapOf(
            '2' to arrayOf('a', 'b', 'c'),
            '3' to arrayOf('d', 'e', 'f'),
            '4' to arrayOf('g', 'h', 'i'),
            '5' to arrayOf('j', 'k', 'l'),
            '6' to arrayOf('m', 'n', 'o'),
            '7' to arrayOf('p', 'q', 'r', 's'),
            '8' to arrayOf('t', 'u', 'v'),
            '9' to arrayOf('w', 'x', 'y', 'z')
        )
        
        fun dfs(index: Int, sb: StringBuilder) {
            if (sb.length == digits.length) {
                results.add(sb.toString())
                
                return
            }
            
            for (c in map[digits[index]]!!) {
                dfs(index + 1, StringBuilder(sb).append(c));
            }
        }
        
        dfs(0, StringBuilder())
        
        return results
    }
}
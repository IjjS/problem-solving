class Solution {
    var left = 0
    var maxLen = 0

    fun extendPalindrome(s: String, i: Int, j: Int) {
        var begin = i
        var end = j

        while (begin >= 0 && end < s.length && s[begin] == s[end]) {
            begin--
            end++
        }

        if (maxLen < end - begin - 1) {
            maxLen = end - begin - 1
            left = ++begin
        }
    }

    fun longestPalindrome(s: String): String {
        val len = s.length

        if (len < 2) return s

        for (i in 0..len - 1) {
            extendPalindrome(s, i, i + 2)
            extendPalindrome(s, i, i + 1)
        }

        return s.substring(left, left + maxLen)
    }
}
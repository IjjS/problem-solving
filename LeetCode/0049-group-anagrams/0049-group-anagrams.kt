class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
      val anagramGrps: MutableMap<String, MutableList<String>> = mutableMapOf()
      for (str in strs) {
        val key = str.toCharArray().sortedArray().joinToString("")
        anagramGrps.getOrPut(key) { mutableListOf() }.add(str)
      }
      return ArrayList(anagramGrps.values)
    }
}
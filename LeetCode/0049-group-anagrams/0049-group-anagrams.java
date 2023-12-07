import java.util.Optional;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGrps = new HashMap<>();

        for (String str : strs) {
            char[] word = str.toCharArray();

            Arrays.sort(word);

            String key = new String(word);

            anagramGrps.putIfAbsent(key, new ArrayList<>());
            anagramGrps.get(key).add(str);
        }

        return new ArrayList<>(anagramGrps.values());
    }
}
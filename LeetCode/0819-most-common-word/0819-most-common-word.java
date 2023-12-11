class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] modified = paragraph.toLowerCase()
            .replaceAll("\\W+", " ")
            .split(" ");
        
        Arrays.stream(modified)
            .filter(word -> !ban.contains(word))
            .forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
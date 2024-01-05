class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        System.out.println(digits);
        
        if (digits.length() == 0) return result;
        
        Map<Character, List<Character>> dict = new HashMap<>();
        
        dict.put('0', Collections.emptyList());
        dict.put('1', Collections.emptyList());
        dict.put('2', List.of('a', 'b', 'c'));
        dict.put('3', List.of('d', 'e', 'f'));
        dict.put('4', List.of('g', 'h', 'i'));
        dict.put('5', List.of('j', 'k', 'l'));
        dict.put('6', List.of('m', 'n', 'o'));
        dict.put('7', List.of('p', 'q', 'r', 's'));
        dict.put('8', List.of('t', 'u', 'v'));
        dict.put('9', List.of('w', 'x', 'y', 'z'));
        dfs(result, dict, digits, 0, new StringBuilder());
        
        return result;
    }
    
    void dfs(List<String> result, Map<Character, List<Character>> dict, String digits, int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }
        
        for (char c : dict.get(digits.charAt(index)))
            dfs(result, dict, digits, index + 1, new StringBuilder(path).append(c));
    }
}
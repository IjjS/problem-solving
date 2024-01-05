class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        System.out.println(digits);
        
        if (digits.length() == 0) return result;
        
        Map<Character, Character[]> dict = new HashMap<>();
        
        dict.put('2', new Character[]{'a', 'b', 'c'});
        dict.put('3', new Character[]{'d', 'e', 'f'});
        dict.put('4', new Character[]{'g', 'h', 'i'});
        dict.put('5', new Character[]{'j', 'k', 'l'});
        dict.put('6', new Character[]{'m', 'n', 'o'});
        dict.put('7', new Character[]{'p', 'q', 'r', 's'});
        dict.put('8', new Character[]{'t', 'u', 'v'});
        dict.put('9', new Character[]{'w', 'x', 'y', 'z'});
        dfs(result, dict, digits, 0, new StringBuilder());
        
        return result;
    }
    
    void dfs(List<String> result, Map<Character, Character[]> dict, String digits, int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }
        
        for (char c : dict.get(digits.charAt(index)))
            dfs(result, dict, digits, index + 1, new StringBuilder(path).append(c));
    }
}
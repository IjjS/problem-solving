class Solution {
    
    static int count = 0;
    
    public int solution(int n) {
        int[] rows = new int[n];
        
        combination(rows, 0);
        
        return count;
    }
    
    void combination(int[] rows, int index) {
        if (rows.length == index) {
            count++;
            
            return;
        }
        
        for (int i = 0; i < rows.length; i++) {
            rows[index] = i;
            
            boolean isPossible = true;
            
            for (int j = 0; j < index; j++) {
                if (rows[index] == rows[j] || (Math.abs(index - j) - Math.abs(rows[index] - rows[j])) == 0) {
                    isPossible = false;
                    
                    break;
                }
            }
            
            if (isPossible) {
                combination(rows, index + 1);
            }
        }
    }
}
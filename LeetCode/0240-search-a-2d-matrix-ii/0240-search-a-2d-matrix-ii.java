class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] array : matrix) {
            if (Arrays.binarySearch(array, target) >= 0) return true;
        }
        
        return false;
    }
}
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {        
        fun dfs(i: Int, j: Int) {
            if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size) {
                return
            }
            
            when (grid[i][j]) {
                '0' -> return
                else -> grid[i][j] = '0'
            }
            
            dfs(i - 1, j)
            dfs(i + 1, j)
            dfs(i, j - 1)
            dfs(i, j + 1)
        }
        
        var islands: Int = 0
        
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    islands++
                }
            }
        }
        
        return islands
    }
}
//https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        
        for(int i=0; i < grid.length;i++) {
            for(int j=0; j < grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        
        return count;
    }
    
    public static void dfs(int i,int j,char[][]grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
            
        grid[i][j] = '0';
        
        dfs(i-1,j,grid); //top
        dfs(i,j-1,grid); //left
        dfs(i+1,j,grid); //down
        dfs(i,j+1,grid); //right
    }
}
//https://leetcode.com/problems/as-far-from-land-as-possible/

class Solution {
    static class Pair {
        int i;
        int j;
        
        Pair() {
            
        }
        
        Pair(int i,int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][]dist = new int[n][m];
        
        ArrayDeque<Pair>q = new ArrayDeque<>();
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair(i,j));
                }
            }
        }
        
        int[][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        //bfs
        int md = -1;
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            for(int k = 0; k < 4; k++) {
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 0) {
                    dist[ni][nj] = dist[rem.i][rem.j] + 1;
                    md = Math.max(dist[ni][nj],md);
                    q.add(new Pair(ni,nj));
                    grid[ni][nj] = -1;
                }
            }
        }
        
        return md;
    }
}
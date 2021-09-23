public class MaxAreaOfIsland {
    class Solution {
        int[][] grid;
        int m;
        int n;

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 0 || grid[i][j] == -1)
                        continue;
                    int area = getArea(i,j);
                    max = Math.max(max,area);
                }
            }
            return max;
        }

        public int getArea(int i, int j) {
            if(grid[i][j] == 0 || grid[i][j] == -1)
                return 0;
            int res = 1;
            grid[i][j] = -1;
            if(i-1>=0)
                res+=getArea(i-1,j);
            if(i+1<m)
                res+=getArea(i+1,j);
            if(j-1>=0)
                res+=getArea(i,j-1);
            if(j+1<n)
                res+=getArea(i,j+1);
            return res;
        }
    }
}

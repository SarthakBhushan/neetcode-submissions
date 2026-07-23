class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]memo = new int[m][n];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return memo(0,0,memo,grid,m,n);
    }

    public int memo(int i, int j, int[][]memo, int[][]grid, int m , int n){
        if(i>=m || j>=n)return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1)return grid[m-1][n-1];
        if(memo[i][j]!=-1)return memo[i][j];
        return memo[i][j] = grid[i][j] + Math.min(memo(i+1,j,memo,grid,m,n), memo(i,j+1,memo,grid,m,n));
    }
}
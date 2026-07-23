class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]memo = new int[m][n];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return memo(0,0,memo,obstacleGrid,m,n);
    }

    public int memo(int i, int j, int[][]memo, int[][]obstacleGrid, int m, int n){
        if(i>=m || j>=n)return 0;
        if(obstacleGrid[i][j]==1)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(memo[i][j]!=-1)return memo[i][j];
        return memo[i][j] = memo(i + 1, j, memo, obstacleGrid, m, n)
                  + memo(i, j + 1, memo, obstacleGrid, m, n);
    }
}
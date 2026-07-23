class Solution {
    public int uniquePaths(int m, int n) {
        int[][]memo = new int[m][n];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return memo(0,0,memo, m,n);
    }

    public int memo(int i, int j, int[][]memo, int m ,int n){
        if(i==m-1 && j==n-1)return 1;
        if(i<m && j<n){
            if(memo[i][j]!=-1)return memo[i][j];
            else{
                return memo[i][j]= memo(i+1,j,memo,m,n) + memo(i,j+1,memo,m,n);
            }
        }
        return memo[m-1][n-1]=0;
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
       int m = word1.length();
       int n = word2.length();
       int[][]memo = new int[m+1][n+1];
       for(int[]row:memo){
        Arrays.fill(row,-1);
       }
       return memo(m,n,memo,word1,word2);
    
    }

    public int memo(int i, int j,int[][]memo, String word1 , String word2){
        if(i==0)return j;
        if(j==0)return i;
        if(memo[i][j]!=-1)return memo[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1))return memo[i][j] = memo(i-1, j-1, memo, word1 , word2);
        return memo[i][j] = 1 + Math.min(memo(i-1, j-1, memo, word1 , word2),Math.min(memo(i-1, j, memo, word1 , word2),memo(i, j-1, memo, word1 , word2)));
        
    }
}

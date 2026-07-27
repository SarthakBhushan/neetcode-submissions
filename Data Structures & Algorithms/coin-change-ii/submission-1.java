class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][]dp = new int[n+1][amount+1];
        dp[n][0] = 1;
        for(int ind=n-1;ind>=0 ; ind--){
            for(int amt =0;amt<=amount;amt++){
                int nottake = dp[ind+1][amt];
                int take =0;
                if(amt>=coins[ind]){
                    take = dp[ind][amt-coins[ind]];
                }
                dp[ind][amt] = take + nottake;
            }
        }
        return dp[0][amount];
    }
}

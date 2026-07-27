class Solution {
    public int change(int amount, int[] coins) {
        int[][]memo = new int[coins.length][amount+1];
        for(int []row:memo)Arrays.fill(row,-1);
        return memo(0,amount,memo,coins);
    }

    public int memo(int ind, int amount, int[][]memo, int[]coins){
        if(amount ==0)return 1;
        if(ind>=coins.length)return 0;
        if(memo[ind][amount]!=-1)return memo[ind][amount];
        int nottake = memo(ind+1,amount, memo, coins);
        int take =0;
        if(amount>=coins[ind]){
            take = memo(ind,amount-coins[ind],memo,coins);
        }
        return memo[ind][amount] = take+nottake;
    }
}

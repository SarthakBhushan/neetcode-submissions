class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int[][]memo = new int[n][2];
        for(int []row:memo)Arrays.fill(row,-1);
        return memo(0,1,memo,n,prices);
    }

    public int memo(int ind, int buy, int[][]memo, int n , int[]prices){
        if(ind>=n)return 0;
        if(memo[ind][buy]!=-1)return memo[ind][buy];
        if(buy==1){
            return memo[ind][buy] = Math.max(-prices[ind]+memo(ind+1,0,memo,n,prices), 0+ memo(ind+1,1,memo,n,prices));
        }
        return memo[ind][buy] = Math.max(prices[ind]+memo(ind+2,1,memo,n,prices), 0+memo(ind+1,0,memo,n,prices));
    }
}

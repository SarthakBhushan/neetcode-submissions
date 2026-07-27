class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int[][]memo = new int[nums.length][2*total+1];
        for(int []row:memo){
            Arrays.fill(row,-1);
        }
        return memo(0,0,nums,memo,total,target);
    }

    public int memo(int ind, int currSum,int []nums, int[][]memo, int total, int target){
        if(ind==nums.length){
            return currSum == target?1:0;
        }
        if(memo[ind][currSum+total]!=-1)return memo[ind][currSum+total];
        int plus = memo(ind+1, currSum+nums[ind],nums, memo,total,target);
        int minus = memo(ind+1, currSum-nums[ind],nums, memo,total,target);
        return memo[ind][currSum+total] = plus +minus;

    }
}

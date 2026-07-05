class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,res,cur,used);
        return res;
    }
    static void backtrack(int[] nums, List<List<Integer>> res, List<Integer>cur,boolean []used){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            cur.add(nums[i]);
            used[i]=true;
            backtrack(nums,res,cur,used);
            cur.remove(cur.size()-1);
            used[i]= false;
        }
    }
}

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<Integer> cur, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur)); 
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break; 
            cur.add(candidates[i]);
            backtrack(candidates, target - candidates[i], cur, i + 1); 
            cur.remove(cur.size() - 1); 
        }
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> count = new HashMap<>();
       for(int n: nums){
        count.put(n,count.getOrDefault(n,0)+1);
       }
       List<Integer>[] bucket = new List[nums.length+1];
       for(int i=0;i<bucket.length;i++){
        bucket[i]= new ArrayList<>();
       } 
       for(int key:count.keySet()){
        int freq = count.get(key);
        bucket[freq].add(key);
       }
       List<Integer> result= new ArrayList<>();
       for(int i= bucket.length-1;i>=0 && result.size()<k;i--){
        if(!bucket[i].isEmpty()){
            result.addAll(bucket[i]);
        }
       }
       int ans[]= new int[k];
       for(int i=0;i<k;i++){
        ans[i]=result.get(i);
       }
       return ans;
    }
}

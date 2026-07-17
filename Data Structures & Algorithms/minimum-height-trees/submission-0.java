class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)return Collections.singletonList(0);
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int m = edges.length;
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[]edge_cnt = new int[n];
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<n;i++){
            edge_cnt[i] = adj.get(i).size();
            if(adj.get(i).size()==1)q.offer(i);
        }
        while(!q.isEmpty()){
            if(n<=2)return new ArrayList<>(q);
            int size = q.size();
            for(int i=0;i<size;i++){
                int node = q.poll();
                n--;
                for(int neighbour: adj.get(node)){
                    edge_cnt[neighbour]--;
                    if(edge_cnt[neighbour]==1)q.offer(neighbour);
                }
            }
        }
        return new ArrayList<>();
    }
}
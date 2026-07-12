class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        if(edges.length!=n-1)return false;
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{0,-1});
        boolean[]vis = new boolean[n];
        vis[0] = true;
        while(!q.isEmpty()){
            int[]cell = q.poll();
            int node = cell[0];
            int parent = cell[1];
            for(int neighbour: adj.get(node)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    q.offer(new int[]{neighbour,node});
                }
                else if(neighbour!=parent)return false;
            }
        }
        for(boolean v: vis){
            if(!v)return false;
        }
        return true;
    }
}

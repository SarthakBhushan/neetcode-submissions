class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int m = edges.length;
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[]vis = new boolean[n];
        return bfs(adj,n,vis);
    }

    private int bfs(ArrayList<ArrayList<Integer>>adj, int n, boolean[]vis){
        int count =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                Queue<Integer>q = new LinkedList<>();
                q.offer(i);
                vis[i]=true;
                count++;
                while(!q.isEmpty()){
                    int node= q.poll();
                    for(int neighbour: adj.get(node)){
                        if(!vis[neighbour]){
                            vis[neighbour]=true;
                            q.offer(neighbour);
                        }
                    }
                }
            }
        }
        return count;
    }
}

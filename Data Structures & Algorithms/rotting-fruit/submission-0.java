class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        int[][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int time =0;
        int fresh =0;
        int rotten =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    rotten++;
                }
                if(grid[i][j]==1)fresh++;
            }
        }

        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[]cell = q.poll();
                int x = cell[0], y = cell[1];
                for(int []d:dir){
                    int nx = x+d[0], ny = y+d[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1){
                        q.offer(new int[]{nx,ny});
                        grid[nx][ny]=2;
                        fresh--;
                    }
                }
            }
            time++;
        }

        if(fresh>0)return -1;
        return time;
    }
}

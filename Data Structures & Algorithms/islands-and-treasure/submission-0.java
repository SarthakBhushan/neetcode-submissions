class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        int[][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int []cell = q.poll();
            int x = cell[0], y = cell[1];
            for(int []d:dir){
                int nx = x+d[0], ny = y+d[1];
                if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==Integer.MAX_VALUE){
                    q.offer(new int[]{nx,ny});
                    grid[nx][ny]= grid[x][y]+1;
                }
            }
        }
    }
}

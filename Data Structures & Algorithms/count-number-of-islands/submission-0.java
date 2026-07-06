class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        boolean[][]vis = new boolean[m][n];
        int[][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    q.offer(new int[]{i,j});
                    vis[i][j]=true;
                    count++;
                    while(!q.isEmpty()){
                        int []cell = q.poll();
                        int x = cell[0];
                        int y = cell[1];
                        for(int[]d:dir){
                            int nx = x+d[0] , ny = y+d[1];
                            if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]=='1' && !vis[nx][ny]){
                                q.offer(new int[]{nx,ny});
                                vis[nx][ny]=true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

class Solution {
    private int m , n;
    private int[][]dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length; 
        border(board);
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='T')board[i][j]='O';
            }
        }
    }

    private void border(char[][]board){
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1)&&board[i][j]=='O'){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[]cell = q.poll();
            int x = cell[0], y = cell[1];
            if(board[x][y]=='O'){
                board[x][y]='T';
                for(int[]d:dir){
                    int nx = x+d[0], ny = y+d[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n){
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}

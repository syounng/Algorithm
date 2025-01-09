import java.io.*;

public class Main {
    static int N;
    static String[][] board1, board2;
    static boolean[][] visited1, visited2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값 입력받기
        N = Integer.parseInt(br.readLine());

        board1 = new String[N][N];
        board2 = new String[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                String val = str.substring(j, j+1);
                board1[i][j] = val;
                //적록색약은 R을 G로 입력
                if(val.equals("R")){
                    board2[i][j] = "G";
                }else board2[i][j] = val;
            }
        }

        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        int cnt1 = 0;
        int cnt2 = 0;

        //적록색약이 아님
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited1[i][j]){
                    dfs(board1, visited1, i, j);
                    cnt1++;
                }

            }
        }

        //적록색약
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    dfs(board2, visited2, i, j);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);

    }
    static void dfs(String[][] board, boolean[][] visited, int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX<0 || newX>=N || newY<0 || newY>=N)
                continue;

            //색상이 다르거나 이미 방문했으면 다음 노드 탐색
            if(!board[newX][newY].equals(board[x][y]) || visited[newX][newY])
                continue;

            dfs(board, visited, newX, newY);
        }
    }
}

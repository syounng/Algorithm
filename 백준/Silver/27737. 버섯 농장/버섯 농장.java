import java.io.*;
import java.util.StringTokenizer;
import java.util.function.DoublePredicate;

public class Main {
    static int N;
    static double M, K, cnt;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(st.nextToken());
        K = Double.parseDouble(st.nextToken());

        board = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //아직 방문하지 않았고 심을 수 있는 곳이면 탐색 시작
        visited = new boolean[N][N];
        double ans = M;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && board[i][j]==0){
                    cnt = 0;
                    dfs(i, j);
                    ans -= Math.ceil(cnt/K);
                }
            }
        }

        if(ans<0 || M==ans) System.out.println("IMPOSSIBLE");
        else System.out.println("POSSIBLE" + "\n" + (int)ans);

    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        cnt++;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX<0 || newX>=N || newY<0 || newY>=N)
                continue;

            if(!visited[newX][newY] && board[newX][newY]==0)
                dfs(newX, newY);
        }
    }
}

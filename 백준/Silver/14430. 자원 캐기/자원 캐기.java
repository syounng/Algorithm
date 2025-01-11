import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dp(i, j);
            }
        }

        System.out.println(dp[N-1][M-1]);

    }
    static void dp(int x, int y){
        //왼쪽, 위 모두 좌표가 없음
        if(x==0 && y==0){
            return;
        }else if(x<1 && y>0){
            dp[x][y] = dp[x][y-1] + dp[x][y];
        }else if(y<1 && x>0){
            dp[x][y] = dp[x-1][y] + dp[x][y];
        }else{
            dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]) + dp[x][y];
        }

    }

}
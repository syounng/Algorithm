import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dp = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                dp(i, j);
            }
        }

        Arrays.sort(dp[N-1]);
        System.out.println(dp[N-1][0]);

    }
    static void dp(int x, int y){
        if(y==0){
            //0열이면 이전 행의 1,2열 중 더 적은 비용을 더해줌
            dp[x][y] += Math.min(dp[x-1][1], dp[x-1][2]);
        }else if(y==1){
            //1열이면 이전 행의 0,2열 중 더 적은 비용을 더해줌
            dp[x][y] += Math.min(dp[x-1][0], dp[x-1][2]);
        }else if(y==2){
            //2열이면 이전 행의 0,1열 중 더 적은 비용을 더해줌
            dp[x][y] += Math.min(dp[x-1][0], dp[x-1][1]);
        }
    }

}
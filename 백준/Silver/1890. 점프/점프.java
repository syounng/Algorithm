import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==0)
                    continue;

                int val = board[i][j];

                int[] dx = {val, 0};
                int[] dy = {0, val};

                for(int k=0; k<2; k++){

                    int ni = i+dx[k];
                    int nj = j+dy[k];

                    if(ni<0 || ni>=n || nj<0 || nj>=n)
                        continue;

                    dp[ni][nj] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }

}


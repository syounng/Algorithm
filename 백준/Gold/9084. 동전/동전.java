import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(br.readLine());

            int[] coins = new int[n];
            for(int k=0; k<n; k++){
                coins[k] = Integer.parseInt(st.nextToken());
            }

            int[][] d = new int[n+1][price+1];
            Arrays.fill(d[0], 0);
            for(int k=1; k<=n; k++){
                d[k][0] = 1;
            }

            for(int j=1; j<=n; j++){
                for(int j2=1; j2<=price; j2++){
                    if(j2 < coins[j-1])
                        d[j][j2] = d[j-1][j2];
                    else
                        d[j][j2] = d[j-1][j2] + d[j][j2-coins[j-1]];
                }
            }
            System.out.println(d[n][price]);
        }
    }
}
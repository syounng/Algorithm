import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Item> items = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new Item(w, v));
        }
        int[][] dp = new int[N+1][K+1];
        Arrays.fill(dp[0], 0);
        for(int i=0; i<=N; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                Item item = items.get(i-1);
                int w = item.w;
                int v = item.v;

                if(j<w){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(v+dp[i-1][j-w], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);

    }
}

class Item{
    int w, v;
    Item(int w, int v){
        this.w = w;
        this.v = v;
    }
}
import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static int[] h, diff;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        h = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(h);
        diff = new int[N-1];
        for(int i=0; i<N-1; i++){
            diff[i] = h[i+1]-h[i];
        }
        Arrays.sort(diff);
        int ans = 0;
        for(int i=0; i<diff.length-(K-1); i++){
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
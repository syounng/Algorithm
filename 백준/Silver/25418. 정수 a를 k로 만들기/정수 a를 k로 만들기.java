import java.io.*;
import java.util.*;

public class Main{
    static int A, K, ans, totalcnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        recursive(K, 0);
        System.out.println(ans);

    }
    static void recursive(int K, int cnt){
        if(ans != 0 || K<A) return;
        if(K == A){
            ans = cnt;
            return;
        }
        if(K <= 0) return;
        if(K%2 != 0) recursive(K-1, cnt+1);
        else recursive(K/2, cnt+1);
        recursive(K-1, cnt+1);

    }

}
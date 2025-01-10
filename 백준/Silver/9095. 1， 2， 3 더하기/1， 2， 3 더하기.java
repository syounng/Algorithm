import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            bw.write(dp(N) + "\n");
        }
        bw.close();
    }
    static int dp(int x){
        if(d[x] != 0) return d[x];
        return d[x] = dp(x-1) + dp(x-2) + dp(x-3);
    }
}
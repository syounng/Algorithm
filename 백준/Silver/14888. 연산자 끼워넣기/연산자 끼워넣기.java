import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] num;
    static int[] calc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        calc = new int[4];
        for(int i=0; i<4; i++){
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int res, int idx){
        if(idx > n-1){
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for(int i=0; i<4; i++){
            if(calc[i] > 0){
                calc[i]--;
                switch(i){
                    case 0:
                        dfs(res+num[idx], idx+1);
                        break;
                    case 1:
                        dfs(res-num[idx], idx+1);
                        break;
                    case 2:
                        dfs(res*num[idx], idx+1);
                        break;
                    case 3:
                        dfs(res/num[idx], idx+1);
                        break;
                }
                calc[i]++;
            }
        }
    }
}
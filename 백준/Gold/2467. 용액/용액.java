import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static long[] liq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        liq = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq[i] = Long.parseLong(st.nextToken());
        }

        long minDist = Long.MAX_VALUE;
        int[] ans = new int[2];

        for(int i=0; i<N-1; i++){
            int start = i+1;
            int end = N-1;

            while(start <= end){
                int mid = (start+end)/2;

                long dist = Math.abs(liq[mid] + liq[i]);
                long sum = liq[mid] + liq[i];

                if(dist < minDist){
                    minDist = dist;
                    ans[0] = i;
                    ans[1] = mid;
                }

                if(sum < 0){
                    //합이 음수면 뒤로
                    start = mid + 1;
                }else{
                    //합이 양수면 앞으로
                    end = mid - 1;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(liq[ans[0]] + " " + liq[ans[1]]);

    }

}
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] light;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine());

        light = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1; //굴다리 최소 크기
        int right = N;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean isPossible(int h) {
        int prev = 0;

        for (int i = 0; i< light.length; i++) {
            if (light[i] - h <= prev) {
                prev = light[i] + h;
            } else {
                return false;
            }
        }

        //마지막 가로등 확인
        return N - prev <= 0;
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] dpMax, dpMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dpMax = new int[n][3];
        dpMin = new int[n][3];
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int val = Integer.parseInt(st.nextToken());
                dpMax[i][j] = dpMin[i][j] = val;
            }
        }

        for(int i = 1; i< n; i++){
            dpMax[i][0] += Math.max(dpMax[i-1][0], dpMax[i-1][1]);
            dpMax[i][1] += Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]);
            dpMax[i][2] += Math.max(dpMax[i-1][1], dpMax[i-1][2]);

            dpMin[i][0] += Math.min(dpMin[i-1][0], dpMin[i-1][1]);
            dpMin[i][1] += Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]);
            dpMin[i][2] += Math.min(dpMin[i-1][1], dpMin[i-1][2]);
        }
        Arrays.sort(dpMax[n-1]);
        Arrays.sort(dpMin[n-1]);
        System.out.println(dpMax[n-1][2] + " " + dpMin[n-1][0]);

    }


}
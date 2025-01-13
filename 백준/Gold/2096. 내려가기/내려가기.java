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
            for(int j=0; j<3; j++){
                findMax(i, j);
                findMin(i, j);
            }
        }
        Arrays.sort(dpMax[n-1]);
        Arrays.sort(dpMin[n-1]);
        System.out.println(dpMax[n-1][2] + " " + dpMin[n-1][0]);

    }
    static void findMax(int x, int y){
        if(y==0){
            dpMax[x][0] += Math.max(dpMax[x-1][0], dpMax[x-1][1]);
        }else if(y==1){
            dpMax[x][1] += Math.max(Math.max(dpMax[x-1][0], dpMax[x-1][1]), dpMax[x-1][2]);
        }else{
            dpMax[x][2] += Math.max(dpMax[x-1][1], dpMax[x-1][2]);
        }
    }
    static void findMin(int x, int y){
        if(y==0){
            dpMin[x][0] += Math.min(dpMin[x-1][0], dpMin[x-1][1]);
        }else if(y==1){
            dpMin[x][1] += Math.min(Math.min(dpMin[x-1][0], dpMin[x-1][1]), dpMin[x-1][2]);
        }else{
            dpMin[x][2] += Math.min(dpMin[x-1][1], dpMin[x-1][2]);
        }
    }

}
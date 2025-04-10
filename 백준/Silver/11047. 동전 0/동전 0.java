import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        int val = 0;
        for(int i=n-1; i>=0; i--){
            val = arr[i];
            if(val<=k){
                cnt += k/val;
                k = k%val;
            }
        }
        System.out.println(cnt);
    }

}


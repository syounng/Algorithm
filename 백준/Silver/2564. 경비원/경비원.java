import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int total = 2*(w+h);

        int n = Integer.parseInt(br.readLine());
        int[] store = new int[n+1];

        for(int i=0; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            //1북 2남 3서 4동
            switch(dir){
                case 1: store[i] = len; break;
                case 4: store[i] = w + len; break;
                case 2: store[i] =  w + h + (w-len); break;
                case 3: store[i] = w + h + w + (h-len); break;
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            int len = Math.abs(store[i] - store[n]);
            ans += Math.min(len, total-len);
        }
        System.out.println(ans);
    }

}





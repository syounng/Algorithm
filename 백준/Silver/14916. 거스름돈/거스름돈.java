import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(br.readLine());
        int ans = -1;
        if(cost<2){
            System.out.println(-1);
            return;
        }
        if(cost%5==0){
            System.out.println(cost/5);
            return;
        }
        for(int i=cost/5; i>=1; i--){//5, 2 사용
            int remain = cost - (5*i);
            if(remain % 2 == 0){
                ans = i + remain/2;
                System.out.println(ans);
                return;
            }
        }
        if(cost%2==0){
            System.out.println(cost/2);
        }else System.out.println(ans);
    }

}


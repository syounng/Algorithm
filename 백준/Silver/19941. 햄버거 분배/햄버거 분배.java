import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static char[] table;
    static boolean[] check;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = new char[N];
        String str = br.readLine();
        for(int i=0; i<N; i++){
            table[i] = str.charAt(i);
        }

        check = new boolean[N];

        for(int i=0; i<N; i++){
            //사람을 찾음
            if(table[i]=='P'){
                //P-K ~ P+K 범위에서 햄버거 찾기
                for(int j=i-K; j<=i+K; j++){
                    //탐색 범위가 table을 벗어나면 다음 인덱스 탐색 시도
                    if(j<0 || j>=N) continue;
                    //햄버거 찾기
                    if(table[j]=='H'){
                        if(check[j]) continue;
                        check[j] = true;
                        //햄버거를 찾았다면 탐색 중지
                        break;
                    }
                }
            }
        }

        int cnt = 0;

        for(boolean tmp: check){
            if(tmp) cnt++;
        }
        System.out.println(cnt);
    }
}
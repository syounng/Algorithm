import java.io.*;
import java.util.*;

public class Main{
    static int N, A, B;
    static int[] t1, t2;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        t1 = new int[A];
        t2 = new int[B];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            t1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++){
            t2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(t1);
        Arrays.sort(t2);

        int leftSpace = N; //남은 바닥 공간
        int ans = 0; //최댓값 저장
        int idx1 = A-2; //t1의 인덱스 (2칸짜리 타일을 선택하는 위치)
        int idx2 = B-1; //t2의 인덱스 (1칸짜리 타일을 선택하는 위치)

        if(N%2 != 0){
            ans += t1[A-1];
            leftSpace -= 1;
            idx1 -= 1;
        }

        while(leftSpace>0){
            int tile1 = 0;
            int tile2 = 0;

            //2x1 타일이 2개 이상이고 2x2 타일이 1개 이상이면
            if(idx1+1 >= 1 && idx2 >= 0){

                tile1 = t1[idx1] + t1[idx1+1];
                tile2 = t2[idx2];

                if(tile1>=tile2){
                    ans += tile1; //예쁨의 최댓값 업데이트
                    idx1 -= 2; //다음으로 탐색할 인덱스 갱신
                    leftSpace -= 2; //남은 바닥 공간 업데이트
                }else {
                    ans += tile2;
                    idx2 -= 1;
                    leftSpace -= 2;
                }
            }else if(idx1+1 >= 1){
                //2x1 타일만 2개 이상 남아있을 때
                tile1 = t1[idx1] + t1[idx1+1];
                ans += tile1;
                idx1 -= 2;
                leftSpace -= 2;
            }else if(idx2 >= 0){
                //2x2 타일만 1개 이상 남아있을 때
                tile2 = t2[idx2];
                ans += tile2;
                idx2 -= 1;
                leftSpace -= 2;
            }else break;
        }
        bw.write(ans+"");
        bw.close();
    }
}
import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long start = 0;
        long end = 1000000000;

        while(start<=end){
            long mid = (start+end)/2;
            if(availableLength(mid) < M){
                //벤 목재가 M보다 모자라면 h를 줄인다.
                end = mid - 1;
            }else if(availableLength(mid) >= M) {
                //벤 목재가 M보다 많으면 h를 늘린다.
                start = mid + 1;
            }
        }
        System.out.println(end);

    }
    static long availableLength(long h){
        //절단기 높이를 h로 두고 나무를 자를 때
        //가져갈 수 있는 나무의 길이
        long length = 0;
        for(int i=0; i<N; i++){
            long val = trees[i]-h;
            if(val>0) length += val;
        }
        return length;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        //점들을 오름차순으로 정렬
        Arrays.sort(points);

        for(int i=0; i<M; i++){
            //선분의 시작점, 끝점 입력받기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(upperBound(end)-lowerBound(start) + "\n");
        }
        bw.close();
    }

    static int lowerBound(int target){
        //타겟보다 작거나 같은 원소 중에 가장 큰 값
        int start = 0;
        int end = N-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(points[mid]>=target){
                //타겟을 찾았거나 타겟이 왼쪽에 있는 경우, 왼쪽 탐색
                end = mid-1;
            }else{
                //타겟이 오른쪽에 있는 경우, 오른쪽 탐색
                start = mid+1;
            }
        }
        return start;
    }

    static int upperBound(int target){
        int start = 0;
        int end = N-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(points[mid]<=target){
                //타겟을 찾았거나 타겟이 오른쪽에 있는 경우, 오른쪽을 탐색
                start = mid+1;
            }else{
                //타겟이 왼쪽에 있는 경우
                end = mid-1;
            }
        }
        return start;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long max = 0;
        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];
        }

        long start = 1; //최소 랜선 길이
        long end = max; //최대 랜선 길이
        long mid = (start+end)/2;

        while(start <= end){
            mid = (start + end)/2;
            //k개의 랜선 각각을 mid길이로 자르면 최대 몇 개가 되는지 계산
            long count = 0;
            for(int i=0; i<k; i++){
                count += arr[i]/mid;
            }

            if(count < n){ //n개보다 적은 수로 잘리면 자르는 길이를 줄이기
                end = mid-1;
            }else { //n개보다 큰 수로 잘리면 자르는 길이를 늘리기 (자르는 길이의 최댓값을 구해야 하므로 가능할 때까지 계속 늘려나가기)
                start = mid+1;
            }
        }
        System.out.println(end);

    }

}


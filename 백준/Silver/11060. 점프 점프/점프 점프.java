import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE); // 초기값을 MAX_VALUE로 설정

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0; // 시작 위치의 점프 횟수는 0

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // 도달 불가능한 위치는 건너뜀

            // 현재 위치에서 점프 가능한 범위 갱신
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j >= n) break; // 배열 범위 초과 시 종료
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1); // 최소 점프 횟수 갱신
            }
        }

        // 마지막 위치에 도달할 수 있는지 확인 후 출력
        System.out.println(dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1]);
    }
}

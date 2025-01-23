import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 주전자 개수
        int K = Integer.parseInt(firstLine[1]); // 친구 수

        long[] makgeolliList = new long[N];
        long maxMakgeolli = 0;

        for (int i = 0; i < N; i++) {
            makgeolliList[i] = Long.parseLong(br.readLine());
            maxMakgeolli = Math.max(maxMakgeolli, makgeolliList[i]);
        }

        long left = 1;
        long right = maxMakgeolli;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = 0;

            for (long makgeolli : makgeolliList) {
                count += makgeolli / mid;
            }

            if (count >= K) {
                result = mid; // 가능하면 결과 갱신
                left = mid + 1; // 더 큰 값을 찾기 위해 left 갱신
            } else {
                right = mid - 1; // mid 값이 너무 크면 줄임
            }
        }

        System.out.println(result);
        br.close();
    }
}
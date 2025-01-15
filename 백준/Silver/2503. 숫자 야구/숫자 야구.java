import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numcnt = new int[1000]; // 숫자의 가능성을 체크하는 배열
        int cnt = 0; // 가능한 숫자의 개수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            int a = num % 10; // 입력 숫자의 첫 번째 자리
            int b = (num / 10) % 10; // 입력 숫자의 두 번째 자리
            int c = (num / 100); // 입력 숫자의 세 번째 자리

            for (int k = 123; k <= 987; k++) {
                int strike_ = 0;
                int ball_ = 0;

                int a_ = k % 10; // 검사 중인 숫자의 첫 번째 자리
                int b_ = (k / 10) % 10; // 검사 중인 숫자의 두 번째 자리
                int c_ = (k / 100); // 검사 중인 숫자의 세 번째 자리

                // 각 자리가 모두 달라야 유효한 숫자
                if (a_ == b_ || b_ == c_ || c_ == a_ || a_ == 0 || b_ == 0 || c_ == 0) {
                    continue;
                }

                // 스트라이크 계산
                if (a == a_) strike_++;
                if (b == b_) strike_++;
                if (c == c_) strike_++;

                // 볼 계산
                if (a == b_ || a == c_) ball_++;
                if (b == a_ || b == c_) ball_++;
                if (c == a_ || c == b_) ball_++;

                // 스트라이크와 볼의 조건이 모두 일치하는 경우
                if (strike == strike_ && ball == ball_) {
                    numcnt[k]++;
                }
            }
        }

        // 가능한 숫자 개수 확인
        for (int i = 123; i <= 987; i++) {
            int a = i % 10;
            int b = (i / 10) % 10;
            int c = (i / 100);

            // 각 자리가 달라야 유효한 숫자
            if (a == b || b == c || c == a || a == 0 || b == 0 || c == 0) {
                continue;
            }

            if (numcnt[i] == N) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

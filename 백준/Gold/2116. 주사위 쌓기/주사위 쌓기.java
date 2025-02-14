import java.util.Scanner;

public class Main {
    static int N; // 주사위 개수
    static int[][] dice; // 주사위 정보를 저장하는 배열
    static int[] opp = {5, 3, 4, 1, 2, 0}; // 마주 보는 면의 인덱스 (A-F, B-D, C-E)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dice = new int[N][6];

        // 주사위 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();
            }
        }

        int ans = 0; // 최댓값 저장

        // 첫 번째 주사위의 윗면 결정 (0~5번 인덱스를 윗면으로 선택)
        for (int i = 0; i < 6; i++) {
            int top = dice[0][i]; // 첫 번째 주사위의 윗면 값
            int bottom = dice[0][opp[i]]; // 첫 번째 주사위의 아랫면 값
            int maxVal = getMaxSide(0, i, opp[i]); // 첫 번째 주사위에서 가능한 최댓값

            // 2~N번째 주사위의 윗면 결정
            for (int diceNum = 1; diceNum < N; diceNum++) {
                for (int j = 0; j < 6; j++) {
                    if (top == dice[diceNum][j]) { // 이전 층의 윗면(top)이 현재 주사위의 어느 면인지 찾음
                        bottom = dice[diceNum][j]; // 현재 주사위의 아랫면
                        top = dice[diceNum][opp[j]]; // 현재 주사위의 윗면 (아랫면과 마주 보는 면)
                        maxVal += getMaxSide(diceNum, j, opp[j]); // 현재 주사위의 최댓값을 더함
                        break; // 찾았으면 반복 종료
                    }
                }
            }

            ans = Math.max(ans, maxVal); // 최댓값 갱신
        }

        System.out.println(ans); // 최댓값 출력
    }

    // 현재 주사위에서 윗면, 아랫면을 제외한 숫자 중 최댓값 반환
    static int getMaxSide(int diceNum, int bottomIdx, int topIdx) {
        int maxSide = 0;
        for (int j = 0; j < 6; j++) {
            if (j != bottomIdx && j != topIdx) { // 윗면, 아랫면 제외
                maxSide = Math.max(maxSide, dice[diceNum][j]);
            }
        }
        return maxSide;
    }
}

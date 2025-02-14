import java.util.*;

public class Main {
    static int N;
    static int[][] dice;
    static int[] opposite = {5, 3, 4, 1, 2, 0}; // 마주 보는 면의 인덱스

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

        int maxSum = 0;

        // 첫 번째 주사위의 아랫면을 6가지 경우로 설정
        for (int bottomIndex = 0; bottomIndex < 6; bottomIndex++) {
            int sum = getMaxSideSum(bottomIndex);
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    // 주어진 아랫면(bottomIndex)일 때 최대 옆면 합을 계산하는 함수
    static int getMaxSideSum(int bottomIndex) {
        int sum = 0;
        int bottomValue = dice[0][bottomIndex]; // 첫 번째 주사위의 아랫면 값
        int topValue = dice[0][opposite[bottomIndex]]; // 윗면 값

        // 주사위 1층부터 N층까지 탐색
        for (int i = 0; i < N; i++) {
            int maxSide = 0; // 옆면 최대값 찾기

            // 현재 주사위에서 윗면과 아랫면을 찾아야 함
            int bottomIdx = -1, topIdx = -1;

            // 현재 주사위에서 아랫면과 윗면의 인덱스를 찾기
            for (int j = 0; j < 6; j++) {
                if (dice[i][j] == bottomValue) bottomIdx = j;
                if (dice[i][j] == topValue) topIdx = j;
            }

            topValue = dice[i][opposite[bottomIdx]]; // 다음 주사위의 윗면

            // 옆면 중 최댓값 찾기 (윗면, 아랫면 제외)
            for (int j = 0; j < 6; j++) {
                if (j != bottomIdx && j != opposite[bottomIdx]) {
                    maxSide = Math.max(maxSide, dice[i][j]);
                }
            }

            sum += maxSide; // 최댓값을 합산
            bottomValue = topValue; // 현재 윗면이 다음 주사위의 아랫면이 됨
        }

        return sum;
    }
}

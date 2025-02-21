import java.util.*;

public class Main {
    static int R, C;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '.' && isIsolated(i, j)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
    
    static boolean isIsolated(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && arr[nx][ny] == '.') {
                count++;
            }
        }
        return count == 1;
    }
}
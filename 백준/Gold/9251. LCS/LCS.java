import java.io.*;
import java.util.*;

public class Main {
    static char[] a, b;
    static int len1, len2;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        len1 = s1.length();
        len2 = s2.length();

        a = s1.toCharArray();
        b = s2.toCharArray();

        d = new int[len1 + 1][len2 + 1];

        // 메모이제이션 배열을 -1로 초기화 (방문 여부 체크)
        for (int[] row : d) {
            Arrays.fill(row, -1);
        }

        System.out.println(lcs(len1, len2)); // 전체 문자열을 비교
    }

    static int lcs(int i, int j) { // a[0..i-1], b[0..j-1]에서의 LCS 길이
        if (i == 0 || j == 0) // 더 이상 비교할 문자가 없으면 0 반환
            return 0;

        if (d[i][j] != -1) // 이미 계산한 값이면 반환
            return d[i][j];

        if (a[i - 1] == b[j - 1]) { // 문자가 같을 경우
            d[i][j] = lcs(i - 1, j - 1) + 1;
        } else { // 문자가 다를 경우
            d[i][j] = Math.max(lcs(i - 1, j), lcs(i, j - 1));
        }

        return d[i][j];
    }
}

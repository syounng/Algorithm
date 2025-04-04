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

        // 인덱스 1부터 사용하기 위해 크기를 len+1로 설정
        a = new char[len1 + 1];
        b = new char[len2 + 1];

        for (int i = 1; i <= len1; i++) {
            a[i] = s1.charAt(i - 1); // 1부터 시작하도록 저장
        }
        for (int i = 1; i <= len2; i++) {
            b[i] = s2.charAt(i - 1); // 1부터 시작하도록 저장
        }

        d = new int[len1 + 1][len2 + 1];

        // 메모이제이션 배열을 -1로 초기화
        for (int[] row : d) {
            Arrays.fill(row, -1);
        }

        System.out.println(lcs(len1, len2)); // 전체 문자열을 비교
    }

    static int lcs(int i, int j) { // a[1..i], b[1..j]에서의 LCS 길이
        if(a[i]==0 || b[j]==0)
            return 0;
        if(d[i][j] != -1){
            return d[i][j];
        }
        if(a[i] == b[j]){
            return d[i][j] = lcs(i-1, j-1) + 1;
        }else{
            return d[i][j] = Math.max(lcs(i-1, j), lcs(i, j-1));
        }
    }
}

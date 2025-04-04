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

        a = new char[len1 + 1];
        b = new char[len2 + 1];

        for (int i = 1; i <= len1; i++) {
            a[i] = s1.charAt(i - 1); // 1부터 시작하도록 저장
        }
        for (int i = 1; i <= len2; i++) {
            b[i] = s2.charAt(i - 1); // 1부터 시작하도록 저장
        }

        d = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (a[i] == b[j])
                    d[i][j] = d[i - 1][j - 1] + 1;
                else
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
            }
        }

        System.out.println(d[len1][len2]);
    }
}

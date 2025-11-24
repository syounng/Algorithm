import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr, sol;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        sol = new int[M];
        pick(0);

    }

    public static void pick(int k){
        if(k == M){
            for(int i=0; i<sol.length; i++){
                System.out.print(sol[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i])
                continue;
            sol[k] = arr[i];
            visited[i] = true;
            pick(k+1);
            visited[i] = false;
        }

    }


}


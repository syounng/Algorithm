import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, x, cnt;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //노드 수
        m = Integer.parseInt(st.nextToken()); //간선 수

        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegrees = new int[n+1];
        Arrays.fill(indegrees, 0);

        for(int i=0; i<m ;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //노드 수
            int v = Integer.parseInt(st.nextToken()); //간선 수
            graph.get(u).add(v);
            indegrees[v]++;
        }

        boolean[] check = new boolean[n+1];
        Arrays.fill(check, false);

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<n+1; i++){
            if(indegrees[i]==0) {
                q.add(i);
                check[i] = true;
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            List<Integer> nexts = graph.get(now);
            for(int i=0; i<nexts.size(); i++){
                int next = nexts.get(i);
                indegrees[next]--;
                if(indegrees[next]==0 && !check[next]){
                    q.add(next);
                    check[next] = true;
                }
            }
        }

        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }

    }


}
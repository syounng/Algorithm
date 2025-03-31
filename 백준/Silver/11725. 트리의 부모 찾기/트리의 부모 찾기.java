import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] parent;
    static List<List<Integer>> graph;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph =  new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n+1];
        Arrays.fill(visited, false);

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[n+1];

        bfs(1);

        for(int i=2; i<n+1; i++)
            System.out.println(parent[i]);


    }
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            List<Integer> nexts = graph.get(now);
            for(int i=0; i<nexts.size(); i++){
                int next = nexts.get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    parent[next] = now;
                }
            }
        }

    }
}
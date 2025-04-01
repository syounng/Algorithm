import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[][] dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                char val = str.charAt(j);
                if(val=='0'){
                    graph[i][j] = 1;
                }else{
                    graph[i][j] = 0;
                }

            }
        }

        dist = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        visited = new boolean[n][n];

        bfs(0, 0);
        System.out.println(dist[n-1][n-1]);

    }

    static void bfs(int x, int y){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(new Node(x, y, 0));

        while(!deque.isEmpty()){
            Node now = deque.pollFirst();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(!visited[nx][ny]){
                    int newDist = dist[now.x][now.y] + graph[nx][ny];
                    if(dist[nx][ny] > newDist){
                        dist[nx][ny] = newDist;
                    }
                    if(graph[nx][ny]==0){
                        deque.addFirst(new Node(nx, ny, newDist));
                    }else{
                        deque.addLast(new Node(nx, ny, newDist));
                    }
                    visited[nx][ny] = true;
                }
            }

        }
    }
}

class Node{
    int x, y, w;
    Node(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}
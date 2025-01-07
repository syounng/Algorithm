import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> q;
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(h==0 && w==0) break;
            else solve(h, w);
        }
        System.out.println(sb);
    }

    static void solve(int h, int w) throws IOException{

        map = new int[h][w];
        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();
        visited = new boolean[h][w];
        int count = 0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(!visited[i][j]){
                    count += bfs(i,j)?1:0;
                }
            }
        }
        sb.append(count + "\n");
    }

    static boolean bfs(int x, int y){
        boolean island = false;

        q.offer(new Node(x, y));
        visited[x][y] = true;
        if(map[x][y]==1) island = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0; i<8; i++){
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                //탐색 범위가 지도 밖을 벗어나면 다음 노드 탐색
                if(newX<0 || newX>=h || newY<0 || newY>=w)
                    continue;

                //인접 노드가 이미 방문했거나 바다이면 다음 노드 탐색
                if(visited[newX][newY] || map[newX][newY]==0)
                    continue;

                //인접 노드가 섬이면 큐에 add
                q.offer(new Node(newX, newY));
                visited[newX][newY] = true;
                if(map[newX][newY]==1) island = true;
            }

        }
        return island;
    }
}

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
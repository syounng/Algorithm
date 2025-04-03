import java.io.*;
import java.util.*;

public class Main {
    static int N, K, S, X, Y;
    static int[][] arr;
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] time;
    static List<Node> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>0){
                    virus.add(new Node(i, j, arr[i][j], 1));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(virus);

        for(Node n: virus){
            q.offer(n);
        }

        for(int time=1; time<=S; time++)
            bfs(time);

        System.out.println(arr[X-1][Y-1]);
    }

    static void bfs(int time){
        //time초에 수행되어야 할 바이러스들만 bfs

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.t != time) //time초가 아니면 탐색 중단
                break;

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;

                if(arr[nx][ny] != 0) //이미 바이러스가 저장된 곳이면 확산 x
                    continue;

                arr[nx][ny] = now.n; //확산된 좌표에 바이러스 번호 저장하기
                q.offer(new Node(nx, ny, now.n, now.t+1));
            }
        }
    }

}

class Node implements Comparable<Node>{
    int x, y, n, t; //바이러스 좌표, 바이러스 번호, 확산이 수행될 시간
    Node(int x, int y, int n, int t){
        this.x = x;
        this.y = y;
        this.n = n;
        this.t = t;
    }

    @Override
    public int compareTo(Node o) {
        return this.n-o.n;
    }
}

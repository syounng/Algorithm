import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] matrix;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j) - 48;
            }
        }

        bfs(new Node(0, 0, 1));
    }

    static void bfs(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.x][node.y] = true;

        while (!que.isEmpty()) {
            //큐에서 한 개 꺼내 방문 처리
            Node now = que.poll();
            if(now.x==n-1 && now.y==m-1){
                System.out.println(now.w);
                return;
            }
            //인접 노드 중 아직 방문하지 않았고 값이 1인 노드들을 큐에 넣음
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if (matrix[nx][ny] == 0 || visited[nx][ny])
                    continue;

                que.add(new Node(nx, ny, now.w+1));
                visited[nx][ny] = true;

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

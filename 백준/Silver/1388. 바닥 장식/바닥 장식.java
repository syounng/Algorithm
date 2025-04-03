import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static char[][] arr;
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
    static void bfs(int x, int y){
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(arr[now.x][now.y]=='|'){
                dx = new int[]{1, -1};
                dy = new int[]{0, 0};
            }else if(arr[now.x][now.y]=='-'){
                dx = new int[]{0, 0};
                dy = new int[]{1, -1};
            }
            for(int i=0; i<2; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if(visited[nx][ny])
                    continue;

                if(arr[now.x][now.y]!=arr[nx][ny])
                    continue;

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;

            }
        }
    }
}

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
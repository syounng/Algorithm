import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = str.charAt(j)-48;
            }
        }

        int totalCnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    result.add(bfs(i, j));
                    totalCnt++;
                }
            }
        }
        System.out.println(totalCnt);
        Collections.sort(result);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
    static int bfs(int x, int y){
        int ret = 0;

        q.offer(new Node(x, y));
        visited[x][y] = true;
        ret++;

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(visited[nx][ny] || arr[nx][ny]==0)
                    continue;

                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                ret++;
            }
        }
        return ret;
    }
}

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
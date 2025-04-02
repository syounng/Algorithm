import java.util.*;
import java.io.*;

public class Main{
    static int r, c;
    static char[][] arr;
    static int[][] t;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] hogVisited;
    static boolean[][] waterVisited;
    static Queue<Node> hq = new LinkedList<>();
    static Queue<Node> wq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        hogVisited = new boolean[r][c];
        waterVisited = new boolean[r][c];
        t = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j]=='*')
                    wq.offer(new Node(i, j));
                else if(arr[i][j]=='S')
                    hq.offer(new Node(i, j));
            }
        }
        
//        int time = 0;
        while(!hq.isEmpty()){
            waterMove();
            if(hogMove()) return;
//            time++;
        }
        System.out.println("KAKTUS");


    }

    static boolean hogMove(){
        int size = hq.size();
        for(int i=0; i<size; i++){
            Node now = hq.poll();

            for(int j=0; j<4; j++){
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if(nx<0 || nx>=r || ny<0 || ny>=c || hogVisited[nx][ny])
                    continue;
                if(arr[nx][ny]=='X' || arr[nx][ny]=='*')
                    continue;

                if(arr[nx][ny]=='D'){
                    System.out.println(t[now.x][now.y]+1);
                    return true;
                }

                t[nx][ny] = t[now.x][now.y]+1;
                hq.offer(new Node(nx, ny));
                hogVisited[nx][ny] = true;
            }
        }
        return false;
    }

    static void waterMove(){
        int size = wq.size();
        for(int i=0; i<size; i++){
            Node now = wq.poll();
            for(int j=0; j<4; j++){
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if(nx<0 || nx>=r || ny<0 || ny>=c || waterVisited[nx][ny])
                    continue;

                if(arr[nx][ny]=='D' || arr[nx][ny]=='X')
                    continue;

                arr[nx][ny] = '*';
                wq.offer(new Node(nx, ny));
                waterVisited[nx][ny] = true;
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
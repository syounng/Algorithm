import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static List<List<Integer>> graph;
    static int[] color;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<v+1; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            color = new int[v+1];

            boolean isBiGraph = true;
            for(int i=1; i<v+1; i++){
                if(color[i]==0){ //아직 방문하지 않은 모든 노드에 대해 bfs를 수행해야 떨어져 있는 그래프도 확인됨
                    if(!bfs(new Node(i, 1))){
                        isBiGraph = false;
                        break;
                    }
                }
            }
            if(isBiGraph){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
    static boolean bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        color[node.num] = 1;

        while(!q.isEmpty()){
            Node now = q.poll();
            List<Integer> nexts = graph.get(now.num);
            for(int next: nexts){
                if(color[next]==now.color)
                    return false;
                else if(color[next]==0){
                    q.add(new Node(next, -now.color));
                    color[next] = -now.color;
                }
            }
        }
        return true;
    }
}

class Node{
    int num, color;
    Node(int num, int color){
        this.num = num;
        this.color = color;
    }
}
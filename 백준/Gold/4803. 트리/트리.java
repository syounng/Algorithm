import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static boolean[] visited;
    static boolean cycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean isEnd = false;
        int caseNum = 1;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) return;

            //인접 리스트 생성
            list = new ArrayList<>();
            for(int i=0; i<N+1; i++){
                list.add(new ArrayList<>());
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                list.get(node1).add(node2);
                list.get(node2).add(node1);
            }

            //방문체크 배열 생성
            visited = new boolean[N+1];

            //트리의 개수 저장하는 변수
            int treeCnt = 0;

            //모든 노드에 대해서 DFS
            for(int i=1; i<=N; i++){
                //아직 방문하지 않은 노드면 dfs탐색
                if(!visited[i]){
                    cycle = false;
                    dfs(i, -1);
                    //dfs 결과 사이클이 아니었다면 트리 하나 세기
                    if(!cycle) treeCnt++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Case " + caseNum + ": ");
            caseNum++;

            if(treeCnt==0){
                sb.append("No trees.");
            }else if(treeCnt==1){
                sb.append("There is one tree.");
            }else if(treeCnt>1){
                sb.append("A forest of " + treeCnt + " trees.");
            }
            System.out.println(sb);
        }
    }

    static void dfs(int now, int parent) {
        visited[now] = true;

        //now와 인접한 노드 방문
        for (int next : list.get(now)) {
            //아직 방문하지 않았다면 dfs탐색
            if (!visited[next]) {
                dfs(next, now);
            } else if (next != parent) {
                // 방문한 적이 있는데 부모 노드가 아니라면 사이클 발생
                cycle = true;
            }
        }
    }
}
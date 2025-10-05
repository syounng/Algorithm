import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        /*
        원소를 차례로 탐색
        정점 : 나가는 화살표만 존재하고, 2개 이상인 경우
        도넛 그래프 : 원래 출발했던 정점으로 돌아오는 경우
        막대 그래프 : 지나온 정점 수보다 1 적게 이동한 경우
        8자 그래프 : 2n+1개의 정점, 2n+2개의 간선인 경우
        - hashmap에서 key에 해당하는 value를 모두 큐에 넣고 node, edge 수 카운트
        - 단, 방문한 정점을 또 방문했다면 
            - value를 큐에 넣지 않기
            - node 수 카운트하지 않기
        */
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        int maxNode = 0;
        for(int[] e : edges){
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        //System.out.println("maxNode : " + maxNode);
        
        int[] indegree = new int[maxNode+1];
        int[] outdegree = new int[maxNode+1];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int newNode = 0;
        
        for(int i=1; i<=maxNode; i++){
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }
        
        for(int[] e : edges){
            outdegree[e[0]]++;
            indegree[e[1]]++;
            map.get(e[0]).add(e[1]);
        }
        
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0 && outdegree[i]>=2){
                newNode = i;
                break;
            }
        }
        
        // for(int i=1; i<=maxNode; i++){
        //      List<Integer> l  = map.get(i);
        //     System.out.print(i + " - ");
        //      for(int tmp : l){
        //          System.out.print(tmp + " ");
        //      }
        //     System.out.println();
        // }  
        
        
        
        for(int i=0; i<map.get(newNode).size(); i++){
            int nodeCnt = 0;
            int edgeCnt = -1;
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(map.get(newNode).get(i));
            boolean[] visited = new boolean[maxNode+1];
            
            while(!q.isEmpty()){
                // System.out.println(q);
                int n = q.poll(); //큐에서 하나 꺼내서
                
                if(visited[n]){ //이미 방문했다면
                    edgeCnt++;
                    continue; //간선만 하나 세기
                }
                
                //아직 방문하지 않았다면 
                for(int j=0; j<map.get(n).size(); j++){ 
                    q.offer(map.get(n).get(j));//꺼낸 노드에서 나가는 화살표 모두 큐에 넣기
                }
                visited[n] = true; //방문체크
                edgeCnt++; //노드와 간선 세기
                nodeCnt++;
            }
            
            /*
            정점 : 나가는 화살표만 존재하고, 2개 이상인 경우
            도넛 그래프 : n개의 정점, n개의 간선이고 원래 출발했던 정점으로 돌아오는 경우
            막대 그래프 : 지나온 정점 수보다 1 적게 이동한 경우
            8자 그래프 : 2n+1개의 정점, 2n+2개의 간선인 경우
            */
            // System.out.println("node " + nodeCnt);
            // System.out.println("edge " + edgeCnt);
            
            if(nodeCnt-1 == edgeCnt){
                stick++;
                // System.out.println("stick");
            } else if(nodeCnt == edgeCnt){
                donut++;
                // System.out.println("donut");
            } else if(nodeCnt+1 == edgeCnt){
                eight++;
                // System.out.println("eight");
            }

        }

        
            int[] ans = {newNode, donut, stick, eight};
            return ans;
    }
}
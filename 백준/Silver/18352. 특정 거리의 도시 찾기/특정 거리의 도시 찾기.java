import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] ans;
    static List<List<Integer>> list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list.get(a).add(b);
            //list.get(b).add(a);
        }

        check = new boolean[N];
        check[X] = true;

        ans = new int[N];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[X] = 0;

        bfs(X);

        boolean found = false;
        for(int i=0; i<N; i++){
            if(ans[i]==K) {
                System.out.println(i+1);
                found=true;
            }
        }
        if(!found) System.out.println(-1);

    }
    static void bfs(int x){
        Queue<City> q = new LinkedList<>();
        q.add(new City(x, 0));

        while(!q.isEmpty()){
            City now = q.poll();
            List<Integer> cities = list.get(now.num);
            for(int i=0; i<cities.size(); i++){
                int next = cities.get(i);
                if(!check[next]){
                    ans[next] = now.len+1;
                    check[next] = true;
                    q.add(new City(next, now.len+1));
                }
            }
        }
    }
}
class City{
    int num, len;
    City(int num, int len){
        this.num = num;
        this.len = len;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //값 입력받기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        //trucks를 큐로 생성하고 모든 트럭을 넣음
        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int nowWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        //다리를 0으로 채워서 초기화
        for(int i=0; i<w; i++){
            bridge.offer(0);
        }
        while(!bridge.isEmpty()){
            time++;
            //다리에서 맨 앞에 있는 것 하나 빼기
            nowWeight -= bridge.poll();
            //다음 트럭이 있다면
            if(!trucks.isEmpty()){
                //하중을 견딜 수 있는지 확인
                //견딜 수 있다면 다음 트럭을 넣음
                if(nowWeight+trucks.peek() <= L){
                    nowWeight += trucks.peek();
                    bridge.offer(trucks.poll());
                }else bridge.offer(0);
            }
        }
        System.out.println(time);
    }
}
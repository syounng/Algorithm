import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //값 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //오른쪽, 위, 왼쪽, 아래
        int[] dir = new int[4];

        //처음 진행 방향은 오른쪽
        int nowDir = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String  command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(num>M){
                System.out.println(-1);
                return;
            }
            if(command.equals("TURN")){
                switch(num){
                    case 0: //왼쪽으로 90도 회전
                        nowDir++;
                        if(nowDir>3) nowDir = 0;
                        break;
                    case 1: //오른쪽으로 90도 회전
                        nowDir--;
                        if(nowDir<0) nowDir = 3;
                }
            } else if(command.equals("MOVE")){
                dir[nowDir] += num;
            }
        }

        int h = dir[0] - dir[2]; //오른쪽-왼쪽
        int v = dir[1] - dir[3]; //위-아래

        if(h<0 || v<0 || h>=M || v>=M){
            System.out.println(-1);
        }else System.out.println(h + " " + v);
    }

}
import java.util.*;

class Solution {
    
    static int[][] giftInfo;
    public int solution(String[] friends, String[] gifts) {
        
        StringTokenizer st;
        //주고받은 선물 정보 저장
        giftInfo = new int[friends.length][friends.length];
        //선물 지수 저장
        int[] giftFactor = new int[friends.length];

        //맵을 사용해 friends 이름을 idx로 표현 
        Map<String, Integer> nameIdx = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            nameIdx.put(friends[i], i);
        }
        
        //giftInfo에 값 입력
        //gifts 배열의 'a b'를 [a의 인덱스][b의 인덱스]로 변환하여 선물 정보 저장
        for(int i=0; i<gifts.length; i++){
            
            st = new StringTokenizer(gifts[i]);
            String f1 = st.nextToken();
            String f2 = st.nextToken();
            
            int giver = nameIdx.get(f1);
            int receiver = nameIdx.get(f2);
            
            giftInfo[giver][receiver]++;
        }
        
        //선물 지수 구하기
        for(int i=0; i<friends.length; i++){
            giftFactor[i] = calcGiftFactor(i);
        }
        
        //giftInfo의 요소를 하나씩 탐색
        boolean[][] visited = new boolean[friends.length][friends.length];
        int[] result = new int[friends.length];
        
        for(int i=0; i<giftInfo.length; i++){
            for(int j=0; j<giftInfo.length; j++){
                
                if(i==j || visited[i][j]) continue;
                
                //0이 아니고(주고 받은 기록이 있고) 주고받은 수가 다르다면
                //[a][b], [b][a] 중 더 큰 값의 행에 해당하는 사람이 선물 한 개 획득
                if((giftInfo[i][j] != 0 || giftInfo[j][i] != 0)
                                        && giftInfo[i][j] != giftInfo[j][i]){
                    
                    visited[i][j] = visited[j][i] = true;
                    
                    int val = giftInfo[i][j] > giftInfo[j][i] ? i : j;
                    result[val]++;
                    continue;
                }
                
                
                //0이거나 (주고 받은 기록이 없거나) 주고 받은 수가 같다면
                //선물 지수가 더 큰 사람이 선물 한 개 획득
                if((giftInfo[i][j] == 0 && giftInfo[j][i] == 0)
                    || giftInfo[i][j] == giftInfo[j][i]){
                    
                    visited[i][j] = visited[j][i] = true;
                    
                    //선물 지수가 다르다면, 선물지수 더 큰 사람이 선물 하나 획득
                    if(giftFactor[i] != giftFactor[j]){
                        int val = giftFactor[i] > giftFactor[j] ? i : j;
                        result[val]++;
                        System.out.println("i:"+i+" j:"+j+" val:"+val);
                    }
                    
                }
            }
        }
        int ans = Arrays.stream(result).max().getAsInt();
        return ans;
    }
    
    //선물 지수 계산기
    //선물 지수 = k가 준 선물의 수 - k가 받은 선물의 수
    static int calcGiftFactor(int k){
        //k가 선물을 준 수 : giftInfo의 k행 값의 합
        int gaveCnt = Arrays.stream(giftInfo[k]).sum();
        //k가 선물을 받은 수 : giftInfo의 k열 값의 합
        int receivedCnt = Arrays.stream(giftInfo)
                                .mapToInt(row -> row[k])
                                .sum();

        return gaveCnt - receivedCnt;
    }
    
}

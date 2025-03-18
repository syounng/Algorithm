# n*n 배열에서 퀸 n개를 같은 행, 같은 열, 같은 대각선 상에 겹치지 않게 두는 경우의 수 구하기

n = int(input())
pos = [0] * n
flag_row = [False] * n
flag_left = [False] * (2*n-1)
flag_right = [False] * (2*n-1)
cnt = 0

def set(i:int) -> None:
    # i열 j행에 퀸을 배치하기
    global cnt
    for j in range(n):
        if (not flag_row[j]
                and not flag_left[i+j]
                and not flag_right[i-j]): # j행, 왼쪽 대각선, 오른쪽 대각선에 퀸을 배치하지 않았다면
            pos[i] = j # i열 j행에 퀸을 배치하기
            if i==n-1: # 마지막 열까지 모두 배치했다면
                cnt = cnt+1 # n개의 퀸을 배치한 경우이므로 cnt 증가시키기
            else:
                flag_row[j] = flag_left[i+j] = flag_right[i-j] = True # j행에 퀸을 배치했다고 표시하기
                set(i+1) # 다음 열에 퀸 배치하러 가기
                flag_row[j] =  flag_left[i+j] = flag_right[i-j] = False # j행에 퀸 배치 해제하기

set(0)
print(cnt)
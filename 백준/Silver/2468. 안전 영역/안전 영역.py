import sys

N = int(sys.stdin.readline())
numbers = []
max_height = 0
flag = []

for i in range(N):
    tmp = list(map(int, sys.stdin.readline().split()))
    max_height = max(max_height, max(tmp))
    numbers.append(tmp)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

max_cnt = 0 # 안전 영역의 최대 개수

def dfs(x:int, y:int, height_:int):
    global numbers, N, flag

    # 현재 좌표를 스택에 추가
    stack = [(x, y)]
    flag[x][y] = True

    while stack: # 스택에 원소가 없어질 때까지

        # 스택에서 하나 꺼내기
        cx, cy = stack.pop()

        # 꺼낸 좌표의 상하좌우 탐색
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            # 좌표가 N*N 배열 안에 있다면
            if 0<=nx<N and 0<=ny<N:

                # 아직 방문 안 한 안전지대인지 확인
                if numbers[nx][ny]>height_ and not flag[nx][ny]:
                    # 스택에 넣기
                    flag[nx][ny] = True
                    stack.append((nx, ny))


# 물 높이 1부터 max_height까지 검사
for height in range(0, max_height+1):
    # 안전지대 개수 초기화
    cnt = 0

    # 방문 체크 배열 초기화
    flag = [[False]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if not flag[i][j] and numbers[i][j]>height: # 아직 방문하지 않았고 안전 지대이면 방문
                dfs(i, j, height)
                cnt+=1
    max_cnt = max(max_cnt, cnt)

print(max_cnt)


import sys

N = int(sys.stdin.readline())
arr = []

for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

white = 0
blue = 0

# 범위 안의 색이 모두 같은지 확인
def is_same(x:int, y:int, k:int):
    # x, y는 범위의 첫 좌표
    first_color = arr[x][y]
    for i in range(x, x+k):
        for j in range(y, y+k):
            # 색이 하나라도 다르면 False 리턴
            if not arr[i][j] == first_color:
                return False
    return True

# 범위 안의 색이 모두 같지 않다면 4개로 범위를 분할하여 재귀
def recur(x: int, y: int, k: int):
    global white, blue
    if is_same(x, y, k):
        if arr[x][y]==0:
            white += 1
        else:
            blue += 1
        return

    recur(x, y, k // 2)
    recur(x, y + k // 2, k // 2)
    recur(x + k // 2, y, k // 2)
    recur(x + k // 2, y + k // 2, k // 2)

recur(0, 0, N)
print(white)
print(blue)
import sys

# 입력받기
N, M = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))
result = 0

# 절단기 높이가 h일 때 가져갈 수 있는 나무 길이
def avail_len(h:int):
    ret = 0
    for i in range(0, len(trees)):
        l = trees[i]-h
        if l > 0: # len이 양수일 때만 누적
            ret += l
    return ret

# (1~가장 큰 나무 높이) 중에 H값을 이분 탐색으로 찾기
pl = 0
pr = max(trees)

while pl <= pr:
    pc = (pl+pr)//2 # 현재 탐색 중인 높이
    total = avail_len(pc)
    if M > total:
        pr = pc - 1
    elif M <= total:
        pl = pc + 1
        result = pc


print(result)

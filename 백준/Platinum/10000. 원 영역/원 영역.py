import sys
from itertools import combinations

n = int(sys.stdin.readline())
circles = []
for _ in range(n):
    circles.append(list(map(int, sys.stdin.readline().split())))

# 각 원의 양쪽 좌표 저장
sides = []
for c in circles:
    sides.append([c[0] - c[1], c[0] + c[1]]) # (중심 좌표 - 반지름, 중심 좌표 + 반지름)

# 시작 좌표 기준으로 정렬, 시작 좌표가 같으면 끝 좌표 기준으로 정렬
sides.sort(key=lambda x: (x[0], x[1]))

# 시작 좌표를 가장 작은 숫자부터, 숫자가 같으면 끝 좌표 먼저 정렬
# 시작 좌표, 끝 좌표를 함께 정렬
sorted = []
for s in sides:
    sorted.append([s[0], 's'])
    sorted.append([s[1], 'e'])

sorted.sort(key=lambda x: (x[0], x[1]))

stk = []
cnt = 0 # 원 영역 개수

for point in sorted:
    total_width = 0 # 안에 원이 여러 개 있을 때 그들의 지름 합
    if point[1]=='s': # 원의 시작 점이면 그냥 넣기
        stk.append(point)
    else: # 원의 끝점이면 영역의 개수를 세어 cnt에 누적
        while stk:
            top = stk.pop()
            if top[1]=='s':
                if total_width==point[0]-top[0]: # 세 원에 의해서 영역이 나뉨
                    cnt+=2
                else: cnt+=1
                stk.append([point[0]-top[0], 'c']) # 원이 하나 만들어짐
                break
            elif top[1]=='c':
                # 너비 누적
                total_width += top[0]

print(cnt+1)





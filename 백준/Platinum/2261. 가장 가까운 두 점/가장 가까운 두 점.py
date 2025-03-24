import sys

n = int(sys.stdin.readline())
points = []
for _ in range(n):
    points.append(list(map(int, sys.stdin.readline().split())))

points.sort()

def pyta(list1: list, list2: list) :
    return (list1[0] - list2[0])**2 + (list1[1] - list2[1])**2

def min_distance(start, end) :
    if end-start==1:
        return pyta(points[start], points[end])
    if end-start==2:
        return min(pyta(points[start], points[start+1]),
                   pyta(points[start+1], points[end]),
                   pyta(points[end], points[start]))

    mid = (start+end)//2 # 현재 탐색하고 있는 범위의 중간
    side_min_val = min(min_distance(start, mid), min_distance(mid+1, end)) # 재귀로 넘어온 두 값 중 비교해서 더 작은 값 저장하기
    mid_val = side_min_val # mid_val(중간 거리)
    candidates = [] # 경계 내부

    for i in range(start, end+1): # 경계 내부에 있는 값 추가하기
        if (points[i][0]-points[mid][0])**2 < side_min_val: # 경계 내부에 있다면 (경계값은 이미 최소값이므로 비교 대상에서 뺐음)
            candidates.append(points[i])

    candidates.sort(key=lambda x: x[1])

    for i in range(len(candidates)):
        for j in range(i+1, len(candidates)):
            if (candidates[j][1]-candidates[i][1])**2 >= side_min_val:
                break
            mid_val = min(mid_val, pyta(candidates[i], candidates[j]))

    return min(side_min_val,mid_val)

print(min_distance(0, n-1))



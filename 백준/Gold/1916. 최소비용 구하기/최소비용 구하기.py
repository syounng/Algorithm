import sys, heapq

# n개의 노드, m개의 간선
# a에서 b까지 가는 데 드는 최소 비용 찾기

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = [[] for i in range(n+1)]

for _ in range(m):
    a, b, w = map(int, sys.stdin.readline().split())
    graph[a].append((w, b))

s, e = map(int, sys.stdin.readline().split())

min_dist = [sys.maxsize]*(n+1)
min_dist[s] = 0

# 큐에 시작 노드를 넣음
# (가중치, 노드 번호)
que = []
heapq.heappush(que, (0, s))

while que:
    now_dist, now_num = heapq.heappop(que)

    if min_dist[now_num] < now_dist:
        continue

    # 지금까지 발견된 next까지의 최단 거리 vs 현재 노드를 거쳐서 next까지 가는 거리 둘 중 작은 값을 min_dist[next]값으로 갱신
    for next_dist, next_num in graph[now_num]:
        new_dist = min_dist[now_num] + next_dist
        if min_dist[next_num] > new_dist:
            min_dist[next_num] = new_dist
            heapq.heappush(que, (new_dist, next_num))

print(min_dist[e])


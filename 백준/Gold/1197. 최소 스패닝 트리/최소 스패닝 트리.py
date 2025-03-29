import sys, heapq
sys.setrecursionlimit(10**9)
v, e = map(int, sys.stdin.readline().split())
graph = []
for i in range(e):
    x, y, w = map(int, sys.stdin.readline().split())
    heapq.heappush(graph,(w, x, y))
p = [i for i in range(v+1)]
total_weight = 0
total_edges = 0
def find(x):
    if p[x]!=x:
        p[x] = find(p[x])
    return p[x]
rank = [1] * (v+1)  # 트리의 랭크(높이) 저장

def union(a, b):
    a_ = find(a)
    b_ = find(b)
    if a_ != b_:
        if rank[a_] > rank[b_]:  # 랭크가 높은 쪽으로 합침
            p[b_] = a_
        elif rank[a_] < rank[b_]:
            p[a_] = b_
        else:
            p[b_] = a_
            rank[a_] += 1
while graph:
    w, a, b = heapq.heappop(graph)
    if find(a)!=find(b):
        total_weight += w
        union(a, b)
        total_edges += 1
        if total_edges == v-1:
            break
print(total_weight)
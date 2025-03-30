import sys
sys.setrecursionlimit(10**9)

v, e = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(v+1)]
check = [False] * (v+1)

for _ in range(e):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(n):
    if not check[n]:
        check[n] = True
        for val in graph[n]:
            if not check[val]:
                dfs(val)
cnt = 0
for i in range(1, v+1):
    if not check[i]:
        dfs(i)
        cnt+=1

print(cnt)
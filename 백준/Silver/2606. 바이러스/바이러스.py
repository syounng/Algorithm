import sys

v = int(sys.stdin.readline())
e = int(sys.stdin.readline())

graph = [[] for _ in range(v+1)]
check = [False] * (v+1)
for _ in range(e):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

cnt = 0
def dfs(n):
    global cnt
    if not check[n]:
        check[n] = True
        cnt += 1
    for val in graph[n]:
        if not check[val]:
            dfs(val)

dfs(1)
print(cnt-1)
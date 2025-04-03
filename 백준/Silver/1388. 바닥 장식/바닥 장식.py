import sys
from collections import deque

def bfs(x, y):
    queue.append((x, y))
    visited[x][y] = True
    
    while queue:
        cx, cy = queue.popleft()
        
        if arr[cx][cy] == '|':
            directions = [(1, 0), (-1, 0)]
        else:  # arr[cx][cy] == '-'
            directions = [(0, 1), (0, -1)]
        
        for dx, dy in directions:
            nx, ny = cx + dx, cy + dy
            
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and arr[cx][cy] == arr[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True

# 입력 처리
n, m = map(int, sys.stdin.readline().split())
arr = [list(sys.stdin.readline().strip()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
queue = deque()

ans = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            bfs(i, j)
            ans += 1

print(ans)

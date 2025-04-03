import sys
from collections import deque

def bfs(x, y):
    count = 1
    queue.append((x, y))
    visited[x][y] = True
    
    while queue:
        cx, cy = queue.popleft()
        
        for dx, dy in directions:
            nx, ny = cx + dx, cy + dy
            
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and arr[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = True
                count += 1
    
    return count

# 입력 처리
n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
queue = deque()
directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

result = []
total_count = 0

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1 and not visited[i][j]:
            result.append(bfs(i, j))
            total_count += 1

print(total_count)
for size in sorted(result):
    print(size)

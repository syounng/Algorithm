import sys
from collections import deque

que = deque()
n = int(sys.stdin.readline())
for i in range(n):
    que.append(i+1)

while len(que)>1:
    que.popleft()
    tmp = que.popleft()
    que.append(tmp)

print(que[0])
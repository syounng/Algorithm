import sys
from collections import deque

tc = int(sys.stdin.readline())

for _ in range(tc):
    cnt = 0
    q = deque()
    n, m = map(int, sys.stdin.readline().split()) # n 문서 개수 m 현재 찾는 문서의 위치
    w = list(map(int, sys.stdin.readline().split())) # 문서의 중요도

    if n==1:
        print(1)
        continue

    for i in range(n):
        q.append([w[i],i+1])

    while q:
        max_val = max(list(q))[0]
        first_element = q[0][0]

        if max_val == first_element:
            tmp = q.popleft()
            cnt += 1

            if tmp[1]==m+1:
                print(cnt)
                break
        else:
            q.append(q.popleft())

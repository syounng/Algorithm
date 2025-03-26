import sys
from collections import deque

n = int(sys.stdin.readline())
que = deque()

def push(x):
    que.append(int(x))
def pop():
    if len(que)==0:
        print(-1)
        return
    print(que.popleft())
def size():
    print(len(que))
def empty():
    if len(que)==0:
        print(1)
        return
    print(0)
def front():
    if len(que)==0:
        print(-1)
        return
    print(que[0])
def back():
    if len(que)==0:
        print(-1)
        return
    print(que[-1])

for _ in range(n):
    val = list(map(str, sys.stdin.readline().split()))
    if val[0]=='push':
        push(val[1])
    elif val[0]=='front':
        front()
    elif val[0]=='back':
        back()
    elif val[0]=='size':
        size()
    elif val[0]=='empty':
        empty()
    elif val[0]=='pop':
        pop()


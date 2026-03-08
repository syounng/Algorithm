from collections import deque

N, M = map(int, input().split()) # 큐의 크기, 뽑아내려고 하는 수의 갯수
numbers = list(map(int, input().split()))

# 1부터 N까지의 자연수가 순서대로 들어있는 리스트 선언
q = deque(range(1, N+1))

result = 0

def isFirst(num):
    if(q.index(num)==0):
        return True
    else:
        return False

def rotate(num):
    length = len(q)

    idxFromLeft = q.index(num)
    idxFromRight = length-idxFromLeft

    if(idxFromLeft <= idxFromRight):
        q.rotate(-idxFromLeft)
        q.popleft()
        return idxFromLeft
    else:
        q.rotate(idxFromRight)
        q.popleft()
        return idxFromRight


for num in numbers:
    if(isFirst(num)):
        q.popleft()
        continue
    else:
        result += rotate(num)

print(result)
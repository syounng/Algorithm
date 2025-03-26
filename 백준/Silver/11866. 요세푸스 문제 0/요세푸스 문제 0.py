import sys

n, k = map(int, sys.stdin.readline().split())
# n명의 사람 중 k번째 사람을 제거

arr = [i+1 for i in range(n)]
result = []
target = k-1

while arr:
    result.append(arr.pop(target))
    if arr:
        target = (target+k-1)%len(arr)

print('<',end="")
for i in range(n-1):
    print(result[i],end=", ")
print(result[n-1],'>',sep="")

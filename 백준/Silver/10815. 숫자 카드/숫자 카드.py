import sys

n = int(sys.stdin.readline())
arr1 = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))

arr1.sort()
result = []

for val in arr2:
    left = 0
    right = n-1

    while left<=right:
        mid = (left+right)//2
        if val == arr1[mid]:
            result.append(1)
            break
        if val > arr1[mid]:
            left = mid + 1
        else:
            right = mid - 1
    if left > right:
        result.append(0)

for r in result:
    print(r, end=" ")


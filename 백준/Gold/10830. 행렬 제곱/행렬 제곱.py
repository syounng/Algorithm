import sys
sys.setrecursionlimit(100000)

N, B = map(int, sys.stdin.readline().split())
arr = []

for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

for i in range(N):
    for j in range(N):
        arr[i][j] %= 1000

# 행렬 A와 B의 곱을 리턴
def mul(A, B):
    n = len(A)
    ret = [[0]*n for _ in range(n)]# 두 행렬의 곱
    for i in range(n): # 행
        for j in range(n): # 열
            for k in range(n):
                ret[i][j] += A[i][k] * B[k][j]
            ret[i][j] %= 1000
    return ret

def recur(b):
    global arr, N

    # 지수가 1이면 원래 행렬을 리턴
    if b==1:
        return arr

    # 지수가 2이면 원래 행렬을 곱셈한 후 각 요소를 1000으로 나눈 값 리턴
    if b==2:
        return mul(arr, arr)

    # 지수가 짝수이면 지수//2의 결과를 거듭제곱한 값을 리턴
    if b%2==0:
        tmp = recur(b//2)
        return mul(tmp, tmp)

    # 지수가 홀수이면 지수//2의 결과를 거듭제곱한 값에 원래 행렬을 한 번 더 곱한 값을 리턴
    else:
        tmp = recur(b//2)
        return mul(mul(tmp, tmp), arr)

result = recur(B)
for i in range(N):
    for j in range(N):
        print(result[i][j], end=" ")
    print()
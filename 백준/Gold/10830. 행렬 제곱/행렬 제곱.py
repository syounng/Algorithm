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
    ret = [[0]*n for _ in range(n)]  # 두 행렬의 곱
    for i in range(n):  # 행
        for j in range(n):  # 열
            for k in range(n):
                ret[i][j] += A[i][k] * B[k][j]
            ret[i][j] %= 1000
    return ret

# 반복문 기반 분할정복
def matrix_power(arr, b):
    n = len(arr)
    result = [[1 if i == j else 0 for j in range(n)] for i in range(n)]  # 단위 행렬 초기화
    base = arr.copy()  # 초기 행렬 복사

    while b > 0:
        if b % 2 == 1:  # 지수가 홀수일 경우 현재 base를 결과에 곱함
            result = mul(result, base)
        base = mul(base, base)  # base를 제곱
        b //= 2  # 지수를 반으로 줄임

    return result

result = matrix_power(arr, B)

for i in range(N):
    for j in range(N):
        print(result[i][j], end=" ")
    print()
import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
B = list(map(int, sys.stdin.readline().split()))

A.sort()
def binary_search(k):
    global A

    pl = 0
    pr = len(A)-1

    while pl <= pr:
        pc = (pl + pr) // 2
        if k == A[pc]:
            return 1
        elif k < A[pc]:
            pr = pc - 1
        else:
            pl = pc + 1
    return 0

for val in B:
    print(binary_search(val))
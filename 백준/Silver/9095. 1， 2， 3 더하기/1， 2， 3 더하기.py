import sys

t = int(sys.stdin.readline())

for i in range(t):
    N = int(sys.stdin.readline())
    cnt = 0
    def recur(n, sum_):
        global cnt
        if n<sum_:
            return
        if n==sum_:
            cnt += 1
            return
        recur(n, sum_ + 1)
        recur(n, sum_ + 2)
        recur(n, sum_ + 3)


    recur(N, 0)

    print(cnt)
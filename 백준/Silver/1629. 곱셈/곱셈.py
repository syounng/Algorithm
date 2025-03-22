import sys

A, B, C = map(int, sys.stdin.readline().split())

def solve(a, b, c):
    if b==1:
        return a%c

    tmp = (solve(a, b//2, c) % c)
    if b%2==0:
        return (tmp * tmp) % c
    else:
        return (tmp * tmp * (a%c)) %c

print(solve(A, B, C))
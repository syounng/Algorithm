import sys

# T 입력받기
# T번 반복하면서 두 정수 입력받기
# 두 정수의 결과 출력하기

t = int(sys.stdin.readline())
for i in range(t):
    a, b = map(int, sys.stdin.readline().split())
    print(a+b)
import sys

# x y w h 입력받기
# x, y, w-x, h-y 중 가장 작은 값을 출력

x = list(map(int, sys.stdin.readline().split()))
print(min(x[0], x[1], x[2]-x[0], x[3]-x[1]))

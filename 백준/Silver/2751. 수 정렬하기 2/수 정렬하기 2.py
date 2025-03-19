# N개의 수가 주어졌을 때 오름차순으로 정렬한 결과 출력
# 이번에는 정렬할 수가 최대 1,000,000개 -> sort()의 시간 복잡도는 O(NlogN) -> 가능하다
import sys
N = int(sys.stdin.readline())
list = []
for _ in range(N):
    list.append(int(sys.stdin.readline()))

list.sort()
for i in range(N):
    print(list[i])
import sys, math

# 9개의 자연수 받기
# 최댓값 찾기
# 최댓값이 몇 번째 수인지 출력하기
max = 0
num = 0
for i in range(9):
    tmp = int(input())
    # tmp가 더 크면 max와 num 갱신
    if tmp > max:
        max = tmp
        num = i+1
print(max)
print(num)

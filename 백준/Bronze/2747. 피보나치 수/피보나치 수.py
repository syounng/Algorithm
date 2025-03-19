# n이 주어졌을 때 n번째 피보나치 수를 출력하여라

n = int(input())

# 0, 1, 2번째값을 초기값으로 정의
list = []
if n==0:
    list = [0]
elif n==1:
    list = [0, 1]
elif n==2:
    list = [0, 1, 1]
else:
    list = [0, 1, 1]
    for i in range(3, n+1):
        list.append(list[i-1]+list[i-2])
print(list[n])
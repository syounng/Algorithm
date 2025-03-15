
t = int(input())
numbers = map(int, input().split())
cnt = 0
for i in numbers:
    if i==1: # 1은 소수가 아님
        continue
    for j in range(2, i):
        if i%j==0: # 2~i 중 나누어 떨어지는 수가 있다면 소수가 아님
            break
    else:
        cnt+=1 # 나누어 떨어지는 수가 없다면 소수임

print(cnt)
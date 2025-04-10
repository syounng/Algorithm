cost = int(input())
ans = -1

if cost < 2:
    print(-1)
    exit()

if cost % 5 == 0:
    print(cost // 5)
    exit()

for i in range(cost // 5, 0, -1):  # 5와 2 사용
    remain = cost - (5 * i)
    if remain % 2 == 0:
        ans = i + (remain // 2)
        print(ans)
        exit()

if cost % 2 == 0:
    print(cost // 2)
else:
    print(ans)

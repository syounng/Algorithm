n, r, c = map(int, input().split())

flag = False
totalcnt = 0
def search(a:int, b:int, k:int, cnt) -> None:
    global totalcnt
    global flag
    if flag:
        return
    # r, c가 현재 탐색 범위에 없으면
    if not(a<=r<a+k and b<=c<b+k):
        totalcnt += cnt + k*k
        return
    if k==2:
        if a==r and b==c:
            totalcnt += cnt + 1
            flag = True
        elif a==r and b+1==c:
            totalcnt += cnt + 2
            flag = True
        elif a+1==r and b==c:
            totalcnt += cnt + 3
            flag = True
        elif a+1==r and b+1==c:
            totalcnt += cnt + 4
            flag = True
        else: # 찾지 못했을 때
            totalcnt += cnt + 4
        return

    search(a, b, k//2, cnt)
    search(a, b+k//2, k//2, cnt)
    search(a+k//2, b ,k//2, cnt)
    search(a+k//2, b+k//2, k//2, cnt)

search(0, 0, 2**n, 0)
print(totalcnt-1)
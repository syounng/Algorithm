import sys
n = int(sys.stdin.readline())
liq = list(map(int, sys.stdin.readline().split()))
liq.sort()
left = 0
right = n-1
ans1 = ans2 = 0
min_sum = sys.maxsize
while 0<=left<n and 0<=right<n and left<right:
    sum = liq[left] + liq[right]
    if abs(sum)<min_sum: # 두 용액 합의 절댓값이 더 작은 경우를 발견함
        min_sum = abs(sum) # min_sum과 ans1, ans2를 업데이트 해주기
        ans1 = left
        ans2 = right
    if sum<0:
        left += 1
    elif sum>0:
        right -= 1
    else:
        break
print(min(liq[ans1], liq[ans2]), max(liq[ans1], liq[ans2]))



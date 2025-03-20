import sys

N, S = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))

cnt = 0
def recur(sum_, index):
    global N, S, cnt

    if index==N: # 모든 원소를 다 탐색했을 때
        if sum_ == S: # 합이 S인 부분 수열을 찾음
            cnt += 1
        return

    # 다음 인접한 숫자 선택하러 가기
    recur(sum_+numbers[index], index + 1) # 현재 원소를 선택하는 경우
    recur(sum_, index+1) # 현재 원소를 선택하지 않는 경우

recur(0, 0)

if S==0: # S가 0일 때 공집합이 포함되므로 카운트에서 제외
    cnt-=1
print(cnt)
import sys

N = int(sys.stdin.readline())

cnt = 0 # 사이클의 길이

def recur(n):
    global cnt, N

    if cnt>1 and n==N: # N과 같아지면 재귀 종료
        return

    if n==0: # 0은 사이클이 1
        cnt+=1
        return

    sum_ = 0 # 각 자리 숫자의 합
    if n<10:
        sum_ = n
    else:
        sum_ = n//10 + n%10

    n2 = (n % 10)*10 + sum_ % 10 # n의 일의 자리 + sum_의 일의 자리
    cnt += 1
    recur(n2)

recur(N)
print(cnt)



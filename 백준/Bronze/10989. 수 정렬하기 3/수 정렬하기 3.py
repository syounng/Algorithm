import sys
N = int(sys.stdin.readline())
num = [0] * 10001 # 각 인덱스에 해당하는 숫자가 몇 번 나왔는지 저장하는 리스트
for _ in range(N):
    val = int(sys.stdin.readline())
    num[val] += 1
for i in range(len(num)):
    for j in range(num[i]):
        print(i)

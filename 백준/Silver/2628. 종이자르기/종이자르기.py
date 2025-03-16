# 가로, 세로 길이와 자르는 개수 받기
# 가로(0)로 자르면 h[]에, 세로(1)로 자르면 w[]에 저장
# w[], h[]에 저장된 숫자를 오름차순 정렬 (0, width 또는 height 포함해서)
# w, h에 저장된 숫자들의 간격 중 가장 큰 간격을 찾아 두 값을 곱하기
width, height = map(int, input().split())
w = [0, width]
h = [0, height]

t = int(input())
for _ in range(t):
    dir, num = map(int, input().split())
    if dir==0:
        h.append(num)
    else:
        w.append(num)

w.sort()
h.sort()

maxW = 0
maxH = 0
for i in range(len(w)-1):
    if maxW < w[i+1]-w[i]:
        maxW = w[i+1]-w[i]

for i in range(len(h)-1):
    if maxH < h[i+1]-h[i]:
        maxH = h[i+1]-h[i]

print(maxW*maxH)

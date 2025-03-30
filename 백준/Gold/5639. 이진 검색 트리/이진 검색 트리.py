import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline
l = []
ans = []
while True:
    try:
        x = int(input())
        l.append(x)
    except:
        break
def search(s, e):
    if s>=e: # 노드가 하나 밖에 없는 트리
        ans.append(l[s]) # ans에 추가
        return
    if l[s]>l[e] or l[s]<l[s+1]: # 현재 루트 노드의 오른쪽 자식이 없음 즉 왼쪽 서브 트리만 존재
        search(s+1, e)
        ans.append(l[s])
        return
    for i in range(s+1, e+1): # 왼쪽 서브 트리, 오른쪽 서브 트리 모두 존재하는 경우
        if l[s] < l[i]:
            break
    search(s+1, i-1)
    search(i, e)
    ans.append(l[s])

search(0, len(l) - 1)
print('\n'.join(map(str, ans)))

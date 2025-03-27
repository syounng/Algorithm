import sys

string = sys.stdin.readline().strip()
t = sys.stdin.readline().strip()
stk = []

for s in string:
    stk.append(s)
    if s == t[-1]: # 스택에 넣은 값이 타겟의 마지막 값과 같으면
        if stk[-len(t):] == list(t): # 스택에서 target 개수만큼 꺼내서 target과 같은지 확인하기
            for _ in range(len(t)): # 같으면 target 개수만큼 pop
                stk.pop()

if not stk:
    print('FRULA')
else:
    for i in stk:
        print(i,end="")